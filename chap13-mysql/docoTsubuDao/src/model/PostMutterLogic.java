package model;

import dao.MutterDAO;

public class PostMutterLogic {
    public void execute (Mutter mutter) {
        MutterDAO dao = new MutterDAO();
        dao.create( mutter );
    }
}

// 修正時刻： Fri Jul  3 16:04:33 2020
