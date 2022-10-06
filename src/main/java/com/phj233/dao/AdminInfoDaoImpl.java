package com.phj233.dao;

import com.phj233.pojo.AdminInfo;
import com.phj233.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminInfoDaoImpl implements AdminInfoDao{

    @Override
    public List<AdminInfo> getAdminInfoList(String sql) throws SQLException {
        ResultSet selectRs = DBUtil.select(sql);
        List<AdminInfo> adminInfos=new ArrayList<>();
        while (selectRs.next()){
            AdminInfo adminInfo=new AdminInfo();
            adminInfo.setaId(selectRs.getInt("Aid"));
            adminInfo.setaLevel(selectRs.getString("Alevel"));
            adminInfo.setaName(selectRs.getString("Aname"));
            adminInfo.setaPwd(selectRs.getString("Apwd"));
            adminInfos.add(adminInfo);
        }
        return adminInfos;
    }

    @Override
    public int addAdminInfo(AdminInfo adminInfo) throws SQLException {
        String sql="insert into admininfo(Aid,Aname,Apwd,Alevel) values(?,?,?,?)";
        return DBUtil.update(sql, adminInfo.getaId(), adminInfo.getaName(), adminInfo.getaPwd(), adminInfo.getaLevel());
    }

    @Override
    public int updateAdmin(AdminInfo adminInfo) throws SQLException {
        String sql="update admininfo set Aname = ? where Aid = ?";
        return DBUtil.update(sql,adminInfo.getaName(),adminInfo.getaId());
    }

    @Override
    public int DeleteAdminInfo(int id) throws SQLException {
        String sql="DELETE FROM admininfo WHERE Aid = "+id;
        return DBUtil.delete(sql);
    }

}
