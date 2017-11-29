package response.models.time_series;

import response.data.time_series.MetaData;
import response.data.time_series.ResponseData;
import response.data.time_series.StockData;
import response.models.ResponseModel;
import response.models.time_series.resolvers.MetaDataResolver;
import response.models.time_series.resolvers.StockDataResolver;

import java.util.List;
import java.util.Map;

public class MonthlyAdjusted implements ResponseModel<ResponseData> {

  @Override
  public String getDataKey() {
    return "Monthly Adjusted Time Series";
  }

  @Override
  public ResponseData resolve(Map<String, String> metaDataResponse,
                              Map<String, Map<String, String>> stockDataResponse) {
    final MetaData metaData = MetaDataResolver.sparse(metaDataResponse);
    final List<StockData> stockData = StockDataResolver.fullWithoutSplitCoefficient(stockDataResponse);
    return new ResponseData(metaData, stockData);
  }
}
