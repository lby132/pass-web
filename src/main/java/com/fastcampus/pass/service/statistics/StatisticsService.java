package com.fastcampus.pass.service.statistics;

import com.fastcampus.pass.repository.statistics.StatisticsRepository;
import com.fastcampus.pass.util.LocalDateTimeUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    public ChartData makeChartData(final LocalDateTime to) {
        LocalDateTime from = to.minusDays(10);

        List<AggregatedStatistics> aggregatedStatisticsList = statisticsRepository.findByStatisticsAtBetweenAndGroupBy(from, to);
        List<String> labels = new ArrayList<>();
        List<Long> attendedCounts = new ArrayList<>();
        List<Long> cancelledCounts = new ArrayList<>();

        for (AggregatedStatistics statistics : aggregatedStatisticsList) {
            labels.add(LocalDateTimeUtils.format(statistics.getStatisticsAt(), LocalDateTimeUtils.MM_DD));
            attendedCounts.add(statistics.getAttendedCount());
            cancelledCounts.add(statistics.getCancelledCount());
        }

        return new ChartData(labels, attendedCounts, cancelledCounts);
    }
}
