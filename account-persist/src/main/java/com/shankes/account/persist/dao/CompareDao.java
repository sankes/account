package com.shankes.account.persist.dao;

import com.shankes.account.persist.helper.DatabaseHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Compare service.
 */
@Repository
public class CompareDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompareDao.class);

    /**
     * 一次性转移数据
     *
     * @return int
     */
    public static int executeOnce() {
        long start = System.currentTimeMillis();
        String sql = "insert into T_TX_ZWYC_DXD t" + "  (select v.OID,"
                + "          v.SHAPE," + "          v.SE_ANNO_CAD_DATA,"
                + "          v.SBMC," + "          v.YXBH,"
                + "          v.DYDJ," + "          v.SSXL,"
                + "          v.SBZLX," + "          v.SSZRQ,"
                + "          v.STATE_ID," + "          v.FHJD,"
                + "          v.CONNECTION," + "          v.SBID,"
                + "          v.YXDW," + "          v.SFBZ,"
                + "          v.BZDX," + "          v.BZYS,"
                + "          v.BZFW," + "          v.PLFS,"
                + "          v.DHZS," + "          v.X,"
                + "          v.Y," + "          v.FHDX,"
                + "          v.QSGT," + "          v.ZZGT,"
                + "          v.BZXSZD," + "          v.BZNR,"
                + "          v.SSDX," + "          v.SSDS,"
                + "          v.KZFHID," + "          v.APPTYPE,"
                + "          v.SSKX," + "          v.SSDKX,"
                + "          v.SSDKXZX," + "          v.VERSIONID,"
                + "          v.SFYC," + "          v.SSFZX"
                + "     from T_TX_ZWYC_DXD_VER v"
                + "    where v.addflag = 2)";
        int rows = DatabaseHelper.executeUpdate(sql);
        long end = System.currentTimeMillis();
        LOGGER.info("总体操作耗时：" + String.valueOf(end - start) + "ms");
        return rows;
    }

    /**
     * Execute multi int [ ].
     *
     * @return the int [ ]
     */
    public static int[] executeMulti() {
        long start = System.currentTimeMillis();
        String querySql = "select v.OID,"
                + "          v.SHAPE," + "          v.SE_ANNO_CAD_DATA,"
                + "          v.SBMC," + "          v.YXBH,"
                + "          v.DYDJ," + "          v.SSXL,"
                + "          v.SBZLX," + "          v.SSZRQ,"
                + "          v.STATE_ID," + "          v.FHJD,"
                + "          v.CONNECTION," + "          v.SBID,"
                + "          v.YXDW," + "          v.SFBZ,"
                + "          v.BZDX," + "          v.BZYS,"
                + "          v.BZFW," + "          v.PLFS,"
                + "          v.DHZS," + "          v.X,"
                + "          v.Y," + "          v.FHDX,"
                + "          v.QSGT," + "          v.ZZGT,"
                + "          v.BZXSZD," + "          v.BZNR,"
                + "          v.SSDX," + "          v.SSDS,"
                + "          v.KZFHID," + "          v.APPTYPE,"
                + "          v.SSKX," + "          v.SSDKX,"
                + "          v.SSDKXZX," + "          v.VERSIONID,"
                + "          v.SFYC," + "          v.SSFZX"
                + "     from T_TX_ZWYC_DXD_VER v"
                + "    where v.addflag = 2";
        List<Map<String, Object>> paramsMapList = DatabaseHelper.executeQuery(querySql);
        String sql = "insert into T_TX_ZWYC_DXD t" + "  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        String sql = "insert into T_TX_ZWYC_DXD ( OID,"
//                + "          SHAPE," + "          SE_ANNO_CAD_DATA,"
//                + "          SBMC," + "          YXBH,"
//                + "          DYDJ," + "          SSXL,"
//                + "          SBZLX," + "          SSZRQ,"
//                + "          STATE_ID," + "          FHJD,"
//                + "          CONNECTION," + "          SBID,"
//                + "          YXDW," + "          SFBZ,"
//                + "          BZDX," + "          BZYS,"
//                + "          BZFW," + "          PLFS,"
//                + "          DHZS," + "          X,"
//                + "          Y," + "          FHDX,"
//                + "          QSGT," + "          ZZGT,"
//                + "          BZXSZD," + "          BZNR,"
//                + "          SSDX," + "          SSDS,"
//                + "          KZFHID," + "          APPTYPE,"
//                + "          SSKX," + "          SSDKX,"
//                + "          SSDKXZX," + "          VERSIONID,"
//                + "          SFYC," + "          SSFZX) "
//                + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int[] rowArr = DatabaseHelper.insertBatchUpdate(sql, paramsMapList);
        long end = System.currentTimeMillis();
        LOGGER.info("分次操作耗时：" + String.valueOf(end - start) + "ms");
        return rowArr;
    }


    /**
     * Execute multi 1 int [ ].
     *
     * @return the int [ ]
     */
    public static int[] executeMulti1() {
        long start = System.currentTimeMillis();
        String querySql = "select v.OID,"
                + "          v.SHAPE," + "          v.SE_ANNO_CAD_DATA,"
                + "          v.SBMC," + "          v.YXBH,"
                + "          v.DYDJ," + "          v.SSXL,"
                + "          v.SBZLX," + "          v.SSZRQ,"
                + "          v.STATE_ID," + "          v.FHJD,"
                + "          v.CONNECTION," + "          v.SBID,"
                + "          v.YXDW," + "          v.SFBZ,"
                + "          v.BZDX," + "          v.BZYS,"
                + "          v.BZFW," + "          v.PLFS,"
                + "          v.DHZS," + "          v.X,"
                + "          v.Y," + "          v.FHDX,"
                + "          v.QSGT," + "          v.ZZGT,"
                + "          v.BZXSZD," + "          v.BZNR,"
                + "          v.SSDX," + "          v.SSDS,"
                + "          v.KZFHID," + "          v.APPTYPE,"
                + "          v.SSKX," + "          v.SSDKX,"
                + "          v.SSDKXZX," + "          v.VERSIONID,"
                + "          v.SFYC," + "          v.SSFZX"
                + "     from T_TX_ZWYC_DXD_VER v"
                + "    where v.addflag = 2";
        List<Map<String, Object>> paramsMapList = DatabaseHelper.executeQuery(querySql);
        String keyList = "OID,SHAPE,SBMC,YXBH,DYDJ,SSXL,SBZLX,SSZRQ,STATE_ID,FHJD,CONNECTION,SBID,YXDW,SFBZ,BZDX,BZYS,BZFW,PLFS,DHZS,X,Y,FHDX,QSGT,ZZGT,BZXSZD,BZNR,SSDX,SSDS,KZFHID,APPTYPE,SSKX,SSDKX,SSDKXZX,VERSIONID,SFYC,SSFZX";
        String sql = "insert into T_TX_ZWYC_DXD(" + keyList + ")" + "  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        List<Object[]> params = new ArrayList<Object[]>();
        String[] keys = keyList.split(",");
        for (Map<String, Object> map : paramsMapList) {
            Object[] object = new Object[keys.length];
            int i = 0;
            for (String key : keys) {
                object[i] = map.get(key);
                i++;
            }
            params.add(object);
        }
        int[] rowArr = DatabaseHelper.executeBatchUpdate(sql, params);
        long end = System.currentTimeMillis();
        LOGGER.info("分次操作耗时：" + String.valueOf(end - start) + "ms");
        return rowArr;
    }
}
