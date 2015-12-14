// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.venus;

import android.graphics.PointF;
import com.cyberlink.youcammakeup.jniproxy.aa;
import com.cyberlink.youcammakeup.jniproxy.ab;
import com.cyberlink.youcammakeup.jniproxy.ac;
import com.cyberlink.youcammakeup.jniproxy.ad;
import com.cyberlink.youcammakeup.jniproxy.af;
import com.cyberlink.youcammakeup.jniproxy.ag;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ak;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.jniproxy.z;
import com.pf.common.utility.m;
import java.util.List;

public class FaceAlignDataUtils
{

    static final int SB_CHIN;
    static final int SB_FOREHEAD_LEFT;
    static final int SB_FOREHEAD_MIDDLE;
    static final int SB_FOREHEAD_RIGHT;
    static final int SB_LANDMARK_AMOUNT;
    static final int SB_LEFT_BROW_BOTTOM;
    static final int SB_LEFT_BROW_LEFT;
    static final int SB_LEFT_BROW_RIGHT;
    static final int SB_LEFT_BROW_TOP;
    static final int SB_LEFT_EAR_BOTTOM;
    static final int SB_LEFT_EAR_TOP;
    static final int SB_LEFT_EYE_BOTTOM;
    static final int SB_LEFT_EYE_CENTER;
    static final int SB_LEFT_EYE_LEFT;
    static final int SB_LEFT_EYE_RIGHT;
    static final int SB_LEFT_EYE_TOP;
    static final int SB_LEFT_FACE_SHAPE_1;
    static final int SB_LEFT_FACE_SHAPE_2;
    static final int SB_MOUTH_BOTTOM_LIP_1;
    static final int SB_MOUTH_BOTTOM_LIP_2;
    static final int SB_MOUTH_INTERP_BOTTOM_LEFT;
    static final int SB_MOUTH_INTERP_BOTTOM_RIGHT;
    static final int SB_MOUTH_INTERP_INNER_LEFT;
    static final int SB_MOUTH_INTERP_INNER_RIGHT;
    static final int SB_MOUTH_INTERP_LOWER_LEFT;
    static final int SB_MOUTH_INTERP_LOWER_RIGHT;
    static final int SB_MOUTH_INTERP_TOP_LEFT;
    static final int SB_MOUTH_INTERP_TOP_RIGHT;
    static final int SB_MOUTH_INTERP_UPPER_LEFT;
    static final int SB_MOUTH_INTERP_UPPER_RIGHT;
    static final int SB_MOUTH_LEFT_CORNER;
    static final int SB_MOUTH_RIGHT_CORNER;
    static final int SB_MOUTH_TOP_LIP_1;
    static final int SB_MOUTH_TOP_LIP_2;
    static final int SB_NOSE_BOTTOM;
    static final int SB_NOSE_BRIDGE_TOP;
    static final int SB_NOSE_LEFT;
    static final int SB_NOSE_RIGHT;
    static final int SB_NOSE_TOP;
    static final int SB_RIGHT_BROW_BOTTOM;
    static final int SB_RIGHT_BROW_LEFT;
    static final int SB_RIGHT_BROW_RIGHT;
    static final int SB_RIGHT_BROW_TOP;
    static final int SB_RIGHT_EAR_BOTTOM;
    static final int SB_RIGHT_EAR_TOP;
    static final int SB_RIGHT_EYE_BOTTOM;
    static final int SB_RIGHT_EYE_CENTER;
    static final int SB_RIGHT_EYE_LEFT;
    static final int SB_RIGHT_EYE_RIGHT;
    static final int SB_RIGHT_EYE_TOP;
    static final int SB_RIGHT_FACE_SHAPE_1;
    static final int SB_RIGHT_FACE_SHAPE_2;
    public static final String TAG = "FaceAlignDataUtils";

    private FaceAlignDataUtils()
    {
    }

    public static void convertFaceAlignData(List list, y y1)
    {
        if (list.size() < SB_LANDMARK_AMOUNT)
        {
            m.e("FaceAlignDataUtils", (new StringBuilder()).append("The size of pointList is less than ").append(SB_LANDMARK_AMOUNT).append(".").toString());
            return;
        } else
        {
            y1.a(getChin(list));
            y1.a(getLeftBrow(list));
            y1.a(getLeftEar(list));
            y1.a(getLeftEye(list));
            y1.a(getLeftShape(list));
            y1.a(getMouth(list));
            y1.a(getNose(list));
            y1.b(getRightBrow(list));
            y1.b(getRightEar(list));
            y1.b(getRightEye(list));
            y1.b(getRightShape(list));
            y1.a(getForehead(list));
            return;
        }
    }

    static aa getChin(List list)
    {
        aa aa1 = new aa();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_CHIN)).x);
        ah1.b(((PointF)list.get(SB_CHIN)).y);
        aa1.a(ah1);
        return aa1;
    }

    static ad getForehead(List list)
    {
        ad ad1 = new ad();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_FOREHEAD_MIDDLE)).x);
        ah1.b(((PointF)list.get(SB_FOREHEAD_MIDDLE)).y);
        ad1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_FOREHEAD_LEFT)).x);
        ah1.b(((PointF)list.get(SB_FOREHEAD_LEFT)).y);
        ad1.b(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_FOREHEAD_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_FOREHEAD_RIGHT)).y);
        ad1.c(ah1);
        return ad1;
    }

    static z getLeftBrow(List list)
    {
        z z1 = new z();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_BROW_LEFT)).x);
        ah1.b(((PointF)list.get(SB_LEFT_BROW_LEFT)).y);
        z1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_BROW_TOP)).x);
        ah1.b(((PointF)list.get(SB_LEFT_BROW_TOP)).y);
        z1.b(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_BROW_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_LEFT_BROW_RIGHT)).y);
        z1.c(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_BROW_BOTTOM)).x);
        ah1.b(((PointF)list.get(SB_LEFT_BROW_BOTTOM)).y);
        z1.d(ah1);
        return z1;
    }

    static ab getLeftEar(List list)
    {
        ab ab1 = new ab();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_EAR_TOP)).x);
        ah1.b(((PointF)list.get(SB_LEFT_EAR_TOP)).y);
        ab1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_EAR_BOTTOM)).x);
        ah1.b(((PointF)list.get(SB_LEFT_EAR_BOTTOM)).y);
        ab1.b(ah1);
        return ab1;
    }

    static ac getLeftEye(List list)
    {
        ac ac1 = new ac();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_EYE_LEFT)).x);
        ah1.b(((PointF)list.get(SB_LEFT_EYE_LEFT)).y);
        ac1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_EYE_TOP)).x);
        ah1.b(((PointF)list.get(SB_LEFT_EYE_TOP)).y);
        ac1.b(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_EYE_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_LEFT_EYE_RIGHT)).y);
        ac1.c(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_EYE_BOTTOM)).x);
        ah1.b(((PointF)list.get(SB_LEFT_EYE_BOTTOM)).y);
        ac1.d(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_EYE_CENTER)).x);
        ah1.b(((PointF)list.get(SB_LEFT_EYE_CENTER)).y);
        ac1.e(ah1);
        return ac1;
    }

    static ak getLeftShape(List list)
    {
        ak ak1 = new ak();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_FACE_SHAPE_1)).x);
        ah1.b(((PointF)list.get(SB_LEFT_FACE_SHAPE_1)).y);
        ak1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_LEFT_FACE_SHAPE_2)).x);
        ah1.b(((PointF)list.get(SB_LEFT_FACE_SHAPE_2)).y);
        ak1.b(ah1);
        return ak1;
    }

    static af getMouth(List list)
    {
        af af1 = new af();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_LEFT_CORNER)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_LEFT_CORNER)).y);
        af1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_RIGHT_CORNER)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_RIGHT_CORNER)).y);
        af1.d(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_TOP_LIP_1)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_TOP_LIP_1)).y);
        af1.b(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_TOP_LIP_2)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_TOP_LIP_2)).y);
        af1.c(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_BOTTOM_LIP_1)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_BOTTOM_LIP_1)).y);
        af1.e(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_BOTTOM_LIP_2)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_BOTTOM_LIP_2)).y);
        af1.f(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_TOP_LEFT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_TOP_LEFT)).y);
        af1.g(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_TOP_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_TOP_RIGHT)).y);
        af1.h(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_BOTTOM_LEFT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_BOTTOM_LEFT)).y);
        af1.i(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_BOTTOM_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_BOTTOM_RIGHT)).y);
        af1.j(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_INNER_LEFT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_INNER_LEFT)).y);
        af1.k(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_INNER_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_INNER_RIGHT)).y);
        af1.l(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_UPPER_LEFT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_UPPER_LEFT)).y);
        af1.m(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_UPPER_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_UPPER_RIGHT)).y);
        af1.n(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_LOWER_LEFT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_LOWER_LEFT)).y);
        af1.o(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_MOUTH_INTERP_LOWER_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_MOUTH_INTERP_LOWER_RIGHT)).y);
        af1.p(ah1);
        return af1;
    }

    static ag getNose(List list)
    {
        ag ag1 = new ag();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_NOSE_LEFT)).x);
        ah1.b(((PointF)list.get(SB_NOSE_LEFT)).y);
        ag1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_NOSE_TOP)).x);
        ah1.b(((PointF)list.get(SB_NOSE_TOP)).y);
        ag1.b(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_NOSE_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_NOSE_RIGHT)).y);
        ag1.c(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_NOSE_BOTTOM)).x);
        ah1.b(((PointF)list.get(SB_NOSE_BOTTOM)).y);
        ag1.d(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_NOSE_BRIDGE_TOP)).x);
        ah1.b(((PointF)list.get(SB_NOSE_BRIDGE_TOP)).y);
        ag1.e(ah1);
        return ag1;
    }

    static z getRightBrow(List list)
    {
        z z1 = new z();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_BROW_LEFT)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_BROW_LEFT)).y);
        z1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_BROW_TOP)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_BROW_TOP)).y);
        z1.b(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_BROW_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_BROW_RIGHT)).y);
        z1.c(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_BROW_BOTTOM)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_BROW_BOTTOM)).y);
        z1.d(ah1);
        return z1;
    }

    static ab getRightEar(List list)
    {
        ab ab1 = new ab();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_EAR_TOP)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_EAR_TOP)).y);
        ab1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_EAR_BOTTOM)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_EAR_BOTTOM)).y);
        ab1.b(ah1);
        return ab1;
    }

    static ac getRightEye(List list)
    {
        ac ac1 = new ac();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_EYE_LEFT)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_EYE_LEFT)).y);
        ac1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_EYE_TOP)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_EYE_TOP)).y);
        ac1.b(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_EYE_RIGHT)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_EYE_RIGHT)).y);
        ac1.c(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_EYE_BOTTOM)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_EYE_BOTTOM)).y);
        ac1.d(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_EYE_CENTER)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_EYE_CENTER)).y);
        ac1.e(ah1);
        return ac1;
    }

    static ak getRightShape(List list)
    {
        ak ak1 = new ak();
        ah ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_FACE_SHAPE_1)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_FACE_SHAPE_1)).y);
        ak1.a(ah1);
        ah1 = new ah();
        ah1.a(((PointF)list.get(SB_RIGHT_FACE_SHAPE_2)).x);
        ah1.b(((PointF)list.get(SB_RIGHT_FACE_SHAPE_2)).y);
        ak1.b(ah1);
        return ak1;
    }

    static void setChin(aa aa1, List list)
    {
        ((PointF)list.get(SB_CHIN)).x = aa1.b().b();
        ((PointF)list.get(SB_CHIN)).y = aa1.b().c();
    }

    static void setForehead(ad ad1, List list)
    {
        ((PointF)list.get(SB_FOREHEAD_MIDDLE)).x = ad1.b().b();
        ((PointF)list.get(SB_FOREHEAD_MIDDLE)).y = ad1.b().c();
        ((PointF)list.get(SB_FOREHEAD_LEFT)).x = ad1.c().b();
        ((PointF)list.get(SB_FOREHEAD_LEFT)).y = ad1.c().c();
        ((PointF)list.get(SB_FOREHEAD_RIGHT)).x = ad1.d().b();
        ((PointF)list.get(SB_FOREHEAD_RIGHT)).y = ad1.d().c();
    }

    static void setLeftBrow(z z1, List list)
    {
        ((PointF)list.get(SB_LEFT_BROW_LEFT)).x = z1.b().b();
        ((PointF)list.get(SB_LEFT_BROW_LEFT)).y = z1.b().c();
        ((PointF)list.get(SB_LEFT_BROW_TOP)).x = z1.c().b();
        ((PointF)list.get(SB_LEFT_BROW_TOP)).y = z1.c().c();
        ((PointF)list.get(SB_LEFT_BROW_RIGHT)).x = z1.d().b();
        ((PointF)list.get(SB_LEFT_BROW_RIGHT)).y = z1.d().c();
        ((PointF)list.get(SB_LEFT_BROW_BOTTOM)).x = z1.e().b();
        ((PointF)list.get(SB_LEFT_BROW_BOTTOM)).y = z1.e().c();
    }

    static void setLeftEar(ab ab1, List list)
    {
        ((PointF)list.get(SB_LEFT_EAR_TOP)).x = ab1.b().b();
        ((PointF)list.get(SB_LEFT_EAR_TOP)).y = ab1.b().c();
        ((PointF)list.get(SB_LEFT_EAR_BOTTOM)).x = ab1.c().b();
        ((PointF)list.get(SB_LEFT_EAR_BOTTOM)).y = ab1.c().c();
    }

    static void setLeftEye(ac ac1, List list)
    {
        ((PointF)list.get(SB_LEFT_EYE_LEFT)).x = ac1.b().b();
        ((PointF)list.get(SB_LEFT_EYE_LEFT)).y = ac1.b().c();
        ((PointF)list.get(SB_LEFT_EYE_TOP)).x = ac1.c().b();
        ((PointF)list.get(SB_LEFT_EYE_TOP)).y = ac1.c().c();
        ((PointF)list.get(SB_LEFT_EYE_RIGHT)).x = ac1.d().b();
        ((PointF)list.get(SB_LEFT_EYE_RIGHT)).y = ac1.d().c();
        ((PointF)list.get(SB_LEFT_EYE_BOTTOM)).x = ac1.e().b();
        ((PointF)list.get(SB_LEFT_EYE_BOTTOM)).y = ac1.e().c();
        ((PointF)list.get(SB_LEFT_EYE_CENTER)).x = ac1.f().b();
        ((PointF)list.get(SB_LEFT_EYE_CENTER)).y = ac1.f().c();
    }

    static void setLeftShape(ak ak1, List list)
    {
        ((PointF)list.get(SB_LEFT_FACE_SHAPE_1)).x = ak1.b().b();
        ((PointF)list.get(SB_LEFT_FACE_SHAPE_1)).y = ak1.b().c();
        ((PointF)list.get(SB_LEFT_FACE_SHAPE_2)).x = ak1.c().b();
        ((PointF)list.get(SB_LEFT_FACE_SHAPE_2)).y = ak1.c().c();
    }

    static void setMouth(af af1, List list)
    {
        ((PointF)list.get(SB_MOUTH_LEFT_CORNER)).x = af1.b().b();
        ((PointF)list.get(SB_MOUTH_LEFT_CORNER)).y = af1.b().c();
        ((PointF)list.get(SB_MOUTH_RIGHT_CORNER)).x = af1.e().b();
        ((PointF)list.get(SB_MOUTH_RIGHT_CORNER)).y = af1.e().c();
        ((PointF)list.get(SB_MOUTH_TOP_LIP_1)).x = af1.c().b();
        ((PointF)list.get(SB_MOUTH_TOP_LIP_1)).y = af1.c().c();
        ((PointF)list.get(SB_MOUTH_TOP_LIP_2)).x = af1.d().b();
        ((PointF)list.get(SB_MOUTH_TOP_LIP_2)).y = af1.d().c();
        ((PointF)list.get(SB_MOUTH_BOTTOM_LIP_1)).x = af1.f().b();
        ((PointF)list.get(SB_MOUTH_BOTTOM_LIP_1)).y = af1.f().c();
        ((PointF)list.get(SB_MOUTH_BOTTOM_LIP_2)).x = af1.g().b();
        ((PointF)list.get(SB_MOUTH_BOTTOM_LIP_2)).y = af1.g().c();
        ((PointF)list.get(SB_MOUTH_INTERP_TOP_LEFT)).x = af1.h().b();
        ((PointF)list.get(SB_MOUTH_INTERP_TOP_LEFT)).y = af1.h().c();
        ((PointF)list.get(SB_MOUTH_INTERP_TOP_RIGHT)).x = af1.i().b();
        ((PointF)list.get(SB_MOUTH_INTERP_TOP_RIGHT)).y = af1.i().c();
        ((PointF)list.get(SB_MOUTH_INTERP_BOTTOM_LEFT)).x = af1.j().b();
        ((PointF)list.get(SB_MOUTH_INTERP_BOTTOM_LEFT)).y = af1.j().c();
        ((PointF)list.get(SB_MOUTH_INTERP_BOTTOM_RIGHT)).x = af1.k().b();
        ((PointF)list.get(SB_MOUTH_INTERP_BOTTOM_RIGHT)).y = af1.k().c();
        ((PointF)list.get(SB_MOUTH_INTERP_INNER_LEFT)).x = af1.l().b();
        ((PointF)list.get(SB_MOUTH_INTERP_INNER_LEFT)).y = af1.l().c();
        ((PointF)list.get(SB_MOUTH_INTERP_INNER_RIGHT)).x = af1.m().b();
        ((PointF)list.get(SB_MOUTH_INTERP_INNER_RIGHT)).y = af1.m().c();
        ((PointF)list.get(SB_MOUTH_INTERP_UPPER_LEFT)).x = af1.n().b();
        ((PointF)list.get(SB_MOUTH_INTERP_UPPER_LEFT)).y = af1.n().c();
        ((PointF)list.get(SB_MOUTH_INTERP_UPPER_RIGHT)).x = af1.o().b();
        ((PointF)list.get(SB_MOUTH_INTERP_UPPER_RIGHT)).y = af1.o().c();
        ((PointF)list.get(SB_MOUTH_INTERP_LOWER_LEFT)).x = af1.p().b();
        ((PointF)list.get(SB_MOUTH_INTERP_LOWER_LEFT)).y = af1.p().c();
        ((PointF)list.get(SB_MOUTH_INTERP_LOWER_RIGHT)).x = af1.q().b();
        ((PointF)list.get(SB_MOUTH_INTERP_LOWER_RIGHT)).y = af1.q().c();
    }

    static void setNose(ag ag1, List list)
    {
        ((PointF)list.get(SB_NOSE_LEFT)).x = ag1.b().b();
        ((PointF)list.get(SB_NOSE_LEFT)).y = ag1.b().c();
        ((PointF)list.get(SB_NOSE_TOP)).x = ag1.c().b();
        ((PointF)list.get(SB_NOSE_TOP)).y = ag1.c().c();
        ((PointF)list.get(SB_NOSE_RIGHT)).x = ag1.d().b();
        ((PointF)list.get(SB_NOSE_RIGHT)).y = ag1.d().c();
        ((PointF)list.get(SB_NOSE_BOTTOM)).x = ag1.e().b();
        ((PointF)list.get(SB_NOSE_BOTTOM)).y = ag1.e().c();
        ((PointF)list.get(SB_NOSE_BRIDGE_TOP)).x = ag1.f().b();
        ((PointF)list.get(SB_NOSE_BRIDGE_TOP)).y = ag1.f().c();
    }

    static void setRightBrow(z z1, List list)
    {
        ((PointF)list.get(SB_RIGHT_BROW_LEFT)).x = z1.b().b();
        ((PointF)list.get(SB_RIGHT_BROW_LEFT)).y = z1.b().c();
        ((PointF)list.get(SB_RIGHT_BROW_TOP)).x = z1.c().b();
        ((PointF)list.get(SB_RIGHT_BROW_TOP)).y = z1.c().c();
        ((PointF)list.get(SB_RIGHT_BROW_RIGHT)).x = z1.d().b();
        ((PointF)list.get(SB_RIGHT_BROW_RIGHT)).y = z1.d().c();
        ((PointF)list.get(SB_RIGHT_BROW_BOTTOM)).x = z1.e().b();
        ((PointF)list.get(SB_RIGHT_BROW_BOTTOM)).y = z1.e().c();
    }

    static void setRightEar(ab ab1, List list)
    {
        ((PointF)list.get(SB_RIGHT_EAR_TOP)).x = ab1.b().b();
        ((PointF)list.get(SB_RIGHT_EAR_TOP)).y = ab1.b().c();
        ((PointF)list.get(SB_RIGHT_EAR_BOTTOM)).x = ab1.c().b();
        ((PointF)list.get(SB_RIGHT_EAR_BOTTOM)).y = ab1.c().c();
    }

    static void setRightEye(ac ac1, List list)
    {
        ((PointF)list.get(SB_RIGHT_EYE_LEFT)).x = ac1.b().b();
        ((PointF)list.get(SB_RIGHT_EYE_LEFT)).y = ac1.b().c();
        ((PointF)list.get(SB_RIGHT_EYE_TOP)).x = ac1.c().b();
        ((PointF)list.get(SB_RIGHT_EYE_TOP)).y = ac1.c().c();
        ((PointF)list.get(SB_RIGHT_EYE_RIGHT)).x = ac1.d().b();
        ((PointF)list.get(SB_RIGHT_EYE_RIGHT)).y = ac1.d().c();
        ((PointF)list.get(SB_RIGHT_EYE_BOTTOM)).x = ac1.e().b();
        ((PointF)list.get(SB_RIGHT_EYE_BOTTOM)).y = ac1.e().c();
        ((PointF)list.get(SB_RIGHT_EYE_CENTER)).x = ac1.f().b();
        ((PointF)list.get(SB_RIGHT_EYE_CENTER)).y = ac1.f().c();
    }

    static void setRightShape(ak ak1, List list)
    {
        ((PointF)list.get(SB_RIGHT_FACE_SHAPE_1)).x = ak1.b().b();
        ((PointF)list.get(SB_RIGHT_FACE_SHAPE_1)).y = ak1.b().c();
        ((PointF)list.get(SB_RIGHT_FACE_SHAPE_2)).x = ak1.c().b();
        ((PointF)list.get(SB_RIGHT_FACE_SHAPE_2)).y = ak1.c().c();
    }

    static 
    {
        SB_LEFT_BROW_LEFT = SB_Face_LandmarkType.SB_LEFT_BROW_LEFT.ordinal();
        SB_LEFT_BROW_TOP = SB_Face_LandmarkType.SB_LEFT_BROW_TOP.ordinal();
        SB_LEFT_BROW_RIGHT = SB_Face_LandmarkType.SB_LEFT_BROW_RIGHT.ordinal();
        SB_LEFT_BROW_BOTTOM = SB_Face_LandmarkType.SB_LEFT_BROW_BOTTOM.ordinal();
        SB_LEFT_EYE_LEFT = SB_Face_LandmarkType.SB_LEFT_EYE_LEFT.ordinal();
        SB_LEFT_EYE_TOP = SB_Face_LandmarkType.SB_LEFT_EYE_TOP.ordinal();
        SB_LEFT_EYE_RIGHT = SB_Face_LandmarkType.SB_LEFT_EYE_RIGHT.ordinal();
        SB_LEFT_EYE_BOTTOM = SB_Face_LandmarkType.SB_LEFT_EYE_BOTTOM.ordinal();
        SB_LEFT_EYE_CENTER = SB_Face_LandmarkType.SB_LEFT_EYE_CENTER.ordinal();
        SB_RIGHT_BROW_LEFT = SB_Face_LandmarkType.SB_RIGHT_BROW_LEFT.ordinal();
        SB_RIGHT_BROW_TOP = SB_Face_LandmarkType.SB_RIGHT_BROW_TOP.ordinal();
        SB_RIGHT_BROW_RIGHT = SB_Face_LandmarkType.SB_RIGHT_BROW_RIGHT.ordinal();
        SB_RIGHT_BROW_BOTTOM = SB_Face_LandmarkType.SB_RIGHT_BROW_BOTTOM.ordinal();
        SB_RIGHT_EYE_LEFT = SB_Face_LandmarkType.SB_RIGHT_EYE_LEFT.ordinal();
        SB_RIGHT_EYE_TOP = SB_Face_LandmarkType.SB_RIGHT_EYE_TOP.ordinal();
        SB_RIGHT_EYE_RIGHT = SB_Face_LandmarkType.SB_RIGHT_EYE_RIGHT.ordinal();
        SB_RIGHT_EYE_BOTTOM = SB_Face_LandmarkType.SB_RIGHT_EYE_BOTTOM.ordinal();
        SB_RIGHT_EYE_CENTER = SB_Face_LandmarkType.SB_RIGHT_EYE_CENTER.ordinal();
        SB_NOSE_LEFT = SB_Face_LandmarkType.SB_NOSE_LEFT.ordinal();
        SB_NOSE_TOP = SB_Face_LandmarkType.SB_NOSE_TOP.ordinal();
        SB_NOSE_RIGHT = SB_Face_LandmarkType.SB_NOSE_RIGHT.ordinal();
        SB_NOSE_BOTTOM = SB_Face_LandmarkType.SB_NOSE_BOTTOM.ordinal();
        SB_MOUTH_LEFT_CORNER = SB_Face_LandmarkType.SB_MOUTH_LEFT_CORNER.ordinal();
        SB_MOUTH_TOP_LIP_1 = SB_Face_LandmarkType.SB_MOUTH_TOP_LIP_1.ordinal();
        SB_MOUTH_TOP_LIP_2 = SB_Face_LandmarkType.SB_MOUTH_TOP_LIP_2.ordinal();
        SB_MOUTH_RIGHT_CORNER = SB_Face_LandmarkType.SB_MOUTH_RIGHT_CORNER.ordinal();
        SB_MOUTH_BOTTOM_LIP_1 = SB_Face_LandmarkType.SB_MOUTH_BOTTOM_LIP_1.ordinal();
        SB_MOUTH_BOTTOM_LIP_2 = SB_Face_LandmarkType.SB_MOUTH_BOTTOM_LIP_2.ordinal();
        SB_CHIN = SB_Face_LandmarkType.SB_CHIN.ordinal();
        SB_LEFT_EAR_TOP = SB_Face_LandmarkType.SB_LEFT_EAR_TOP.ordinal();
        SB_LEFT_EAR_BOTTOM = SB_Face_LandmarkType.SB_LEFT_EAR_BOTTOM.ordinal();
        SB_LEFT_FACE_SHAPE_1 = SB_Face_LandmarkType.SB_LEFT_FACE_SHAPE_1.ordinal();
        SB_LEFT_FACE_SHAPE_2 = SB_Face_LandmarkType.SB_LEFT_FACE_SHAPE_2.ordinal();
        SB_RIGHT_EAR_TOP = SB_Face_LandmarkType.SB_RIGHT_EAR_TOP.ordinal();
        SB_RIGHT_EAR_BOTTOM = SB_Face_LandmarkType.SB_RIGHT_EAR_BOTTOM.ordinal();
        SB_RIGHT_FACE_SHAPE_1 = SB_Face_LandmarkType.SB_RIGHT_FACE_SHAPE_1.ordinal();
        SB_RIGHT_FACE_SHAPE_2 = SB_Face_LandmarkType.SB_RIGHT_FACE_SHAPE_2.ordinal();
        SB_MOUTH_INTERP_TOP_RIGHT = SB_Face_LandmarkType.SB_MOUTH_INTERP_TOP_RIGHT.ordinal();
        SB_MOUTH_INTERP_TOP_LEFT = SB_Face_LandmarkType.SB_MOUTH_INTERP_TOP_LEFT.ordinal();
        SB_MOUTH_INTERP_BOTTOM_RIGHT = SB_Face_LandmarkType.SB_MOUTH_INTERP_BOTTOM_RIGHT.ordinal();
        SB_MOUTH_INTERP_BOTTOM_LEFT = SB_Face_LandmarkType.SB_MOUTH_INTERP_BOTTOM_LEFT.ordinal();
        SB_MOUTH_INTERP_INNER_RIGHT = SB_Face_LandmarkType.SB_MOUTH_INTERP_INNER_RIGHT.ordinal();
        SB_MOUTH_INTERP_INNER_LEFT = SB_Face_LandmarkType.SB_MOUTH_INTERP_INNER_LEFT.ordinal();
        SB_MOUTH_INTERP_UPPER_LEFT = SB_Face_LandmarkType.SB_MOUTH_INTERP_UPPER_LEFT.ordinal();
        SB_MOUTH_INTERP_UPPER_RIGHT = SB_Face_LandmarkType.SB_MOUTH_INTERP_UPPER_RIGHT.ordinal();
        SB_MOUTH_INTERP_LOWER_LEFT = SB_Face_LandmarkType.SB_MOUTH_INTERP_LOWER_LEFT.ordinal();
        SB_MOUTH_INTERP_LOWER_RIGHT = SB_Face_LandmarkType.SB_MOUTH_INTERP_LOWER_RIGHT.ordinal();
        SB_NOSE_BRIDGE_TOP = SB_Face_LandmarkType.SB_NOSE_BRIDGE_TOP.ordinal();
        SB_FOREHEAD_MIDDLE = SB_Face_LandmarkType.SB_FOREHEAD_MIDDLE.ordinal();
        SB_FOREHEAD_LEFT = SB_Face_LandmarkType.SB_FOREHEAD_LEFT.ordinal();
        SB_FOREHEAD_RIGHT = SB_Face_LandmarkType.SB_FOREHEAD_RIGHT.ordinal();
        SB_LANDMARK_AMOUNT = SB_Face_LandmarkType.SB_LANDMARK_AMOUNT.ordinal();
    }

    private class SB_Face_LandmarkType extends Enum
    {

        private static final SB_Face_LandmarkType $VALUES[];
        public static final SB_Face_LandmarkType SB_CHIN;
        public static final SB_Face_LandmarkType SB_FOREHEAD_LEFT;
        public static final SB_Face_LandmarkType SB_FOREHEAD_MIDDLE;
        public static final SB_Face_LandmarkType SB_FOREHEAD_RIGHT;
        public static final SB_Face_LandmarkType SB_LANDMARK_AMOUNT;
        public static final SB_Face_LandmarkType SB_LEFT_BROW_BOTTOM;
        public static final SB_Face_LandmarkType SB_LEFT_BROW_LEFT;
        public static final SB_Face_LandmarkType SB_LEFT_BROW_RIGHT;
        public static final SB_Face_LandmarkType SB_LEFT_BROW_TOP;
        public static final SB_Face_LandmarkType SB_LEFT_EAR_BOTTOM;
        public static final SB_Face_LandmarkType SB_LEFT_EAR_TOP;
        public static final SB_Face_LandmarkType SB_LEFT_EYE_BOTTOM;
        public static final SB_Face_LandmarkType SB_LEFT_EYE_CENTER;
        public static final SB_Face_LandmarkType SB_LEFT_EYE_LEFT;
        public static final SB_Face_LandmarkType SB_LEFT_EYE_RIGHT;
        public static final SB_Face_LandmarkType SB_LEFT_EYE_TOP;
        public static final SB_Face_LandmarkType SB_LEFT_FACE_SHAPE_1;
        public static final SB_Face_LandmarkType SB_LEFT_FACE_SHAPE_2;
        public static final SB_Face_LandmarkType SB_MOUTH_BOTTOM_LIP_1;
        public static final SB_Face_LandmarkType SB_MOUTH_BOTTOM_LIP_2;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_BOTTOM_LEFT;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_BOTTOM_RIGHT;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_INNER_LEFT;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_INNER_RIGHT;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_LOWER_LEFT;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_LOWER_RIGHT;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_TOP_LEFT;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_TOP_RIGHT;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_UPPER_LEFT;
        public static final SB_Face_LandmarkType SB_MOUTH_INTERP_UPPER_RIGHT;
        public static final SB_Face_LandmarkType SB_MOUTH_LEFT_CORNER;
        public static final SB_Face_LandmarkType SB_MOUTH_RIGHT_CORNER;
        public static final SB_Face_LandmarkType SB_MOUTH_TOP_LIP_1;
        public static final SB_Face_LandmarkType SB_MOUTH_TOP_LIP_2;
        public static final SB_Face_LandmarkType SB_NOSE_BOTTOM;
        public static final SB_Face_LandmarkType SB_NOSE_BRIDGE_TOP;
        public static final SB_Face_LandmarkType SB_NOSE_LEFT;
        public static final SB_Face_LandmarkType SB_NOSE_RIGHT;
        public static final SB_Face_LandmarkType SB_NOSE_TOP;
        public static final SB_Face_LandmarkType SB_RIGHT_BROW_BOTTOM;
        public static final SB_Face_LandmarkType SB_RIGHT_BROW_LEFT;
        public static final SB_Face_LandmarkType SB_RIGHT_BROW_RIGHT;
        public static final SB_Face_LandmarkType SB_RIGHT_BROW_TOP;
        public static final SB_Face_LandmarkType SB_RIGHT_EAR_BOTTOM;
        public static final SB_Face_LandmarkType SB_RIGHT_EAR_TOP;
        public static final SB_Face_LandmarkType SB_RIGHT_EYE_BOTTOM;
        public static final SB_Face_LandmarkType SB_RIGHT_EYE_CENTER;
        public static final SB_Face_LandmarkType SB_RIGHT_EYE_LEFT;
        public static final SB_Face_LandmarkType SB_RIGHT_EYE_RIGHT;
        public static final SB_Face_LandmarkType SB_RIGHT_EYE_TOP;
        public static final SB_Face_LandmarkType SB_RIGHT_FACE_SHAPE_1;
        public static final SB_Face_LandmarkType SB_RIGHT_FACE_SHAPE_2;

        public static SB_Face_LandmarkType valueOf(String s)
        {
            return (SB_Face_LandmarkType)Enum.valueOf(com/cyberlink/youcammakeup/venus/FaceAlignDataUtils$SB_Face_LandmarkType, s);
        }

        public static SB_Face_LandmarkType[] values()
        {
            return (SB_Face_LandmarkType[])$VALUES.clone();
        }

        static 
        {
            SB_LEFT_BROW_LEFT = new SB_Face_LandmarkType("SB_LEFT_BROW_LEFT", 0);
            SB_LEFT_BROW_TOP = new SB_Face_LandmarkType("SB_LEFT_BROW_TOP", 1);
            SB_LEFT_BROW_RIGHT = new SB_Face_LandmarkType("SB_LEFT_BROW_RIGHT", 2);
            SB_LEFT_BROW_BOTTOM = new SB_Face_LandmarkType("SB_LEFT_BROW_BOTTOM", 3);
            SB_LEFT_EYE_LEFT = new SB_Face_LandmarkType("SB_LEFT_EYE_LEFT", 4);
            SB_LEFT_EYE_TOP = new SB_Face_LandmarkType("SB_LEFT_EYE_TOP", 5);
            SB_LEFT_EYE_RIGHT = new SB_Face_LandmarkType("SB_LEFT_EYE_RIGHT", 6);
            SB_LEFT_EYE_BOTTOM = new SB_Face_LandmarkType("SB_LEFT_EYE_BOTTOM", 7);
            SB_LEFT_EYE_CENTER = new SB_Face_LandmarkType("SB_LEFT_EYE_CENTER", 8);
            SB_RIGHT_BROW_LEFT = new SB_Face_LandmarkType("SB_RIGHT_BROW_LEFT", 9);
            SB_RIGHT_BROW_TOP = new SB_Face_LandmarkType("SB_RIGHT_BROW_TOP", 10);
            SB_RIGHT_BROW_RIGHT = new SB_Face_LandmarkType("SB_RIGHT_BROW_RIGHT", 11);
            SB_RIGHT_BROW_BOTTOM = new SB_Face_LandmarkType("SB_RIGHT_BROW_BOTTOM", 12);
            SB_RIGHT_EYE_LEFT = new SB_Face_LandmarkType("SB_RIGHT_EYE_LEFT", 13);
            SB_RIGHT_EYE_TOP = new SB_Face_LandmarkType("SB_RIGHT_EYE_TOP", 14);
            SB_RIGHT_EYE_RIGHT = new SB_Face_LandmarkType("SB_RIGHT_EYE_RIGHT", 15);
            SB_RIGHT_EYE_BOTTOM = new SB_Face_LandmarkType("SB_RIGHT_EYE_BOTTOM", 16);
            SB_RIGHT_EYE_CENTER = new SB_Face_LandmarkType("SB_RIGHT_EYE_CENTER", 17);
            SB_NOSE_LEFT = new SB_Face_LandmarkType("SB_NOSE_LEFT", 18);
            SB_NOSE_TOP = new SB_Face_LandmarkType("SB_NOSE_TOP", 19);
            SB_NOSE_RIGHT = new SB_Face_LandmarkType("SB_NOSE_RIGHT", 20);
            SB_NOSE_BOTTOM = new SB_Face_LandmarkType("SB_NOSE_BOTTOM", 21);
            SB_MOUTH_LEFT_CORNER = new SB_Face_LandmarkType("SB_MOUTH_LEFT_CORNER", 22);
            SB_MOUTH_TOP_LIP_1 = new SB_Face_LandmarkType("SB_MOUTH_TOP_LIP_1", 23);
            SB_MOUTH_TOP_LIP_2 = new SB_Face_LandmarkType("SB_MOUTH_TOP_LIP_2", 24);
            SB_MOUTH_RIGHT_CORNER = new SB_Face_LandmarkType("SB_MOUTH_RIGHT_CORNER", 25);
            SB_MOUTH_BOTTOM_LIP_1 = new SB_Face_LandmarkType("SB_MOUTH_BOTTOM_LIP_1", 26);
            SB_MOUTH_BOTTOM_LIP_2 = new SB_Face_LandmarkType("SB_MOUTH_BOTTOM_LIP_2", 27);
            SB_CHIN = new SB_Face_LandmarkType("SB_CHIN", 28);
            SB_LEFT_EAR_TOP = new SB_Face_LandmarkType("SB_LEFT_EAR_TOP", 29);
            SB_LEFT_EAR_BOTTOM = new SB_Face_LandmarkType("SB_LEFT_EAR_BOTTOM", 30);
            SB_LEFT_FACE_SHAPE_1 = new SB_Face_LandmarkType("SB_LEFT_FACE_SHAPE_1", 31);
            SB_LEFT_FACE_SHAPE_2 = new SB_Face_LandmarkType("SB_LEFT_FACE_SHAPE_2", 32);
            SB_RIGHT_EAR_TOP = new SB_Face_LandmarkType("SB_RIGHT_EAR_TOP", 33);
            SB_RIGHT_EAR_BOTTOM = new SB_Face_LandmarkType("SB_RIGHT_EAR_BOTTOM", 34);
            SB_RIGHT_FACE_SHAPE_1 = new SB_Face_LandmarkType("SB_RIGHT_FACE_SHAPE_1", 35);
            SB_RIGHT_FACE_SHAPE_2 = new SB_Face_LandmarkType("SB_RIGHT_FACE_SHAPE_2", 36);
            SB_MOUTH_INTERP_TOP_RIGHT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_TOP_RIGHT", 37);
            SB_MOUTH_INTERP_TOP_LEFT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_TOP_LEFT", 38);
            SB_MOUTH_INTERP_BOTTOM_RIGHT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_BOTTOM_RIGHT", 39);
            SB_MOUTH_INTERP_BOTTOM_LEFT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_BOTTOM_LEFT", 40);
            SB_MOUTH_INTERP_INNER_RIGHT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_INNER_RIGHT", 41);
            SB_MOUTH_INTERP_INNER_LEFT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_INNER_LEFT", 42);
            SB_MOUTH_INTERP_UPPER_LEFT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_UPPER_LEFT", 43);
            SB_MOUTH_INTERP_UPPER_RIGHT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_UPPER_RIGHT", 44);
            SB_MOUTH_INTERP_LOWER_LEFT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_LOWER_LEFT", 45);
            SB_MOUTH_INTERP_LOWER_RIGHT = new SB_Face_LandmarkType("SB_MOUTH_INTERP_LOWER_RIGHT", 46);
            SB_NOSE_BRIDGE_TOP = new SB_Face_LandmarkType("SB_NOSE_BRIDGE_TOP", 47);
            SB_FOREHEAD_MIDDLE = new SB_Face_LandmarkType("SB_FOREHEAD_MIDDLE", 48);
            SB_FOREHEAD_LEFT = new SB_Face_LandmarkType("SB_FOREHEAD_LEFT", 49);
            SB_FOREHEAD_RIGHT = new SB_Face_LandmarkType("SB_FOREHEAD_RIGHT", 50);
            SB_LANDMARK_AMOUNT = new SB_Face_LandmarkType("SB_LANDMARK_AMOUNT", 51);
            $VALUES = (new SB_Face_LandmarkType[] {
                SB_LEFT_BROW_LEFT, SB_LEFT_BROW_TOP, SB_LEFT_BROW_RIGHT, SB_LEFT_BROW_BOTTOM, SB_LEFT_EYE_LEFT, SB_LEFT_EYE_TOP, SB_LEFT_EYE_RIGHT, SB_LEFT_EYE_BOTTOM, SB_LEFT_EYE_CENTER, SB_RIGHT_BROW_LEFT, 
                SB_RIGHT_BROW_TOP, SB_RIGHT_BROW_RIGHT, SB_RIGHT_BROW_BOTTOM, SB_RIGHT_EYE_LEFT, SB_RIGHT_EYE_TOP, SB_RIGHT_EYE_RIGHT, SB_RIGHT_EYE_BOTTOM, SB_RIGHT_EYE_CENTER, SB_NOSE_LEFT, SB_NOSE_TOP, 
                SB_NOSE_RIGHT, SB_NOSE_BOTTOM, SB_MOUTH_LEFT_CORNER, SB_MOUTH_TOP_LIP_1, SB_MOUTH_TOP_LIP_2, SB_MOUTH_RIGHT_CORNER, SB_MOUTH_BOTTOM_LIP_1, SB_MOUTH_BOTTOM_LIP_2, SB_CHIN, SB_LEFT_EAR_TOP, 
                SB_LEFT_EAR_BOTTOM, SB_LEFT_FACE_SHAPE_1, SB_LEFT_FACE_SHAPE_2, SB_RIGHT_EAR_TOP, SB_RIGHT_EAR_BOTTOM, SB_RIGHT_FACE_SHAPE_1, SB_RIGHT_FACE_SHAPE_2, SB_MOUTH_INTERP_TOP_RIGHT, SB_MOUTH_INTERP_TOP_LEFT, SB_MOUTH_INTERP_BOTTOM_RIGHT, 
                SB_MOUTH_INTERP_BOTTOM_LEFT, SB_MOUTH_INTERP_INNER_RIGHT, SB_MOUTH_INTERP_INNER_LEFT, SB_MOUTH_INTERP_UPPER_LEFT, SB_MOUTH_INTERP_UPPER_RIGHT, SB_MOUTH_INTERP_LOWER_LEFT, SB_MOUTH_INTERP_LOWER_RIGHT, SB_NOSE_BRIDGE_TOP, SB_FOREHEAD_MIDDLE, SB_FOREHEAD_LEFT, 
                SB_FOREHEAD_RIGHT, SB_LANDMARK_AMOUNT
            });
        }

        private SB_Face_LandmarkType(String s, int i)
        {
            super(s, i);
        }
    }

}
