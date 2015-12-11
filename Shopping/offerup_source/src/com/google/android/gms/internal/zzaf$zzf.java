// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzse, zzsc, zzsa, 
//            zzrx, zzsh, zzrw

public final class zzJ extends zzry
{

    public String version;
    public String zzid[];
    public String zzie[];
    public zzid zzif[];
    public zzid zzig[];
    public zzid zzih[];
    public zzid zzii[];
    public zzid zzij[];
    public zzid zzik[];
    public String zzil;
    public String zzim;
    public String zzin;
    public zzid zzio;
    public float zzip;
    public boolean zziq;
    public String zzir[];
    public int zzis;

    public static zzJ zzc(byte abyte0[])
    {
        return (zzJ)zzse.zza(new <init>(), abyte0);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof <init>))
            {
                return false;
            }
            obj = (<init>)obj;
            if (!zzsc.equals(zzid, ((zzid) (obj)).zzid))
            {
                return false;
            }
            if (!zzsc.equals(zzie, ((zzie) (obj)).zzie))
            {
                return false;
            }
            if (!zzsc.equals(zzif, ((zzif) (obj)).zzif))
            {
                return false;
            }
            if (!zzsc.equals(zzig, ((zzig) (obj)).zzig))
            {
                return false;
            }
            if (!zzsc.equals(zzih, ((zzih) (obj)).zzih))
            {
                return false;
            }
            if (!zzsc.equals(zzii, ((zzii) (obj)).zzii))
            {
                return false;
            }
            if (!zzsc.equals(zzij, ((zzij) (obj)).zzij))
            {
                return false;
            }
            if (!zzsc.equals(zzik, ((zzik) (obj)).zzik))
            {
                return false;
            }
            if (zzil == null)
            {
                if (((zzil) (obj)).zzil != null)
                {
                    return false;
                }
            } else
            if (!zzil.equals(((zzil) (obj)).zzil))
            {
                return false;
            }
            if (zzim == null)
            {
                if (((zzim) (obj)).zzim != null)
                {
                    return false;
                }
            } else
            if (!zzim.equals(((zzim) (obj)).zzim))
            {
                return false;
            }
            if (zzin == null)
            {
                if (((zzin) (obj)).zzin != null)
                {
                    return false;
                }
            } else
            if (!zzin.equals(((zzin) (obj)).zzin))
            {
                return false;
            }
            if (version == null)
            {
                if (((version) (obj)).version != null)
                {
                    return false;
                }
            } else
            if (!version.equals(((version) (obj)).version))
            {
                return false;
            }
            if (zzio == null)
            {
                if (((zzio) (obj)).zzio != null)
                {
                    return false;
                }
            } else
            if (!zzio.equals(((equals) (obj)).zzio))
            {
                return false;
            }
            if (Float.floatToIntBits(zzip) != Float.floatToIntBits(((zzip) (obj)).zzip))
            {
                return false;
            }
            if (zziq != ((zziq) (obj)).zziq)
            {
                return false;
            }
            if (!zzsc.equals(zzir, ((zzir) (obj)).zzir))
            {
                return false;
            }
            if (zzis != ((zzis) (obj)).zzis)
            {
                return false;
            }
            if (zzbik == null || zzbik.isEmpty())
            {
                if (((pty) (obj)).zzbik != null && !((zzbik) (obj)).zzbik.isEmpty())
                {
                    return false;
                }
            } else
            {
                return zzbik.equals(((ls) (obj)).zzbik);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        boolean flag = false;
        int k1 = getClass().getName().hashCode();
        int l1 = zzsc.hashCode(zzid);
        int i2 = zzsc.hashCode(zzie);
        int j2 = zzsc.hashCode(zzif);
        int k2 = zzsc.hashCode(zzig);
        int l2 = zzsc.hashCode(zzih);
        int i3 = zzsc.hashCode(zzii);
        int j3 = zzsc.hashCode(zzij);
        int k3 = zzsc.hashCode(zzik);
        int i;
        int j;
        int k;
        int l;
        int i1;
        char c;
        int j1;
        int l3;
        int i4;
        int j4;
        if (zzil == null)
        {
            i = 0;
        } else
        {
            i = zzil.hashCode();
        }
        if (zzim == null)
        {
            j = 0;
        } else
        {
            j = zzim.hashCode();
        }
        if (zzin == null)
        {
            k = 0;
        } else
        {
            k = zzin.hashCode();
        }
        if (version == null)
        {
            l = 0;
        } else
        {
            l = version.hashCode();
        }
        if (zzio == null)
        {
            i1 = 0;
        } else
        {
            i1 = zzio.hashCode();
        }
        l3 = Float.floatToIntBits(zzip);
        if (zziq)
        {
            c = '\u04CF';
        } else
        {
            c = '\u04D5';
        }
        i4 = zzsc.hashCode(zzir);
        j4 = zzis;
        j1 = ((flag) ? 1 : 0);
        if (zzbik != null)
        {
            if (zzbik.isEmpty())
            {
                j1 = ((flag) ? 1 : 0);
            } else
            {
                j1 = zzbik.hashCode();
            }
        }
        return (((c + ((i1 + (l + (k + (j + (i + (((((((((k1 + 527) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + j3) * 31 + k3) * 31) * 31) * 31) * 31) * 31) * 31 + l3) * 31) * 31 + i4) * 31 + j4) * 31 + j1;
    }

    protected final int zzB()
    {
        boolean flag = false;
        int k4 = super.zzB();
        int j;
        int k;
        int k2;
        if (zzie != null && zzie.length > 0)
        {
            int i = 0;
            k = 0;
            int l;
            int i3;
            for (l = 0; i < zzie.length; l = i3)
            {
                String s = zzie[i];
                int l3 = k;
                i3 = l;
                if (s != null)
                {
                    i3 = l + 1;
                    l3 = k + zzrx.zzfA(s);
                }
                i++;
                k = l3;
            }

            k = k4 + k + l * 1;
        } else
        {
            k = k4;
        }
        j = k;
        if (zzif != null)
        {
            j = k;
            if (zzif.length > 0)
            {
                j = k;
                for (k = 0; k < zzif.length;)
                {
                    Code code = zzif[k];
                    int i1 = j;
                    if (code != null)
                    {
                        i1 = j + zzrx.zzc(2, code);
                    }
                    k++;
                    j = i1;
                }

            }
        }
        k = j;
        if (zzig != null)
        {
            k = j;
            if (zzig.length > 0)
            {
                for (k = 0; k < zzig.length;)
                {
                    Code code1 = zzig[k];
                    int j1 = j;
                    if (code1 != null)
                    {
                        j1 = j + zzrx.zzc(3, code1);
                    }
                    k++;
                    j = j1;
                }

                k = j;
            }
        }
        j = k;
        if (zzih != null)
        {
            j = k;
            if (zzih.length > 0)
            {
                j = k;
                for (k = 0; k < zzih.length;)
                {
                    Code code2 = zzih[k];
                    int k1 = j;
                    if (code2 != null)
                    {
                        k1 = j + zzrx.zzc(4, code2);
                    }
                    k++;
                    j = k1;
                }

            }
        }
        k = j;
        if (zzii != null)
        {
            k = j;
            if (zzii.length > 0)
            {
                for (k = 0; k < zzii.length;)
                {
                    Code code3 = zzii[k];
                    int l1 = j;
                    if (code3 != null)
                    {
                        l1 = j + zzrx.zzc(5, code3);
                    }
                    k++;
                    j = l1;
                }

                k = j;
            }
        }
        j = k;
        if (zzij != null)
        {
            j = k;
            if (zzij.length > 0)
            {
                j = k;
                for (k = 0; k < zzij.length;)
                {
                    Code code4 = zzij[k];
                    int i2 = j;
                    if (code4 != null)
                    {
                        i2 = j + zzrx.zzc(6, code4);
                    }
                    k++;
                    j = i2;
                }

            }
        }
        k = j;
        if (zzik != null)
        {
            k = j;
            if (zzik.length > 0)
            {
                for (k = 0; k < zzik.length;)
                {
                    Code code5 = zzik[k];
                    int j2 = j;
                    if (code5 != null)
                    {
                        j2 = j + zzrx.zzc(7, code5);
                    }
                    k++;
                    j = j2;
                }

                k = j;
            }
        }
        j = k;
        if (!zzil.equals(""))
        {
            j = k + zzrx.zzn(9, zzil);
        }
        k = j;
        if (!zzim.equals(""))
        {
            k = j + zzrx.zzn(10, zzim);
        }
        j = k;
        if (!zzin.equals("0"))
        {
            j = k + zzrx.zzn(12, zzin);
        }
        k = j;
        if (!version.equals(""))
        {
            k = j + zzrx.zzn(13, version);
        }
        k2 = k;
        if (zzio != null)
        {
            k2 = k + zzrx.zzc(14, zzio);
        }
        j = k2;
        if (Float.floatToIntBits(zzip) != Float.floatToIntBits(0.0F))
        {
            j = k2 + zzrx.zzc(15, zzip);
        }
        k = j;
        if (zzir != null)
        {
            k = j;
            if (zzir.length > 0)
            {
                k = 0;
                k2 = 0;
                int j3;
                int i4;
                for (j3 = 0; k < zzir.length; j3 = i4)
                {
                    String s1 = zzir[k];
                    k4 = k2;
                    i4 = j3;
                    if (s1 != null)
                    {
                        i4 = j3 + 1;
                        k4 = k2 + zzrx.zzfA(s1);
                    }
                    k++;
                    k2 = k4;
                }

                k = j + k2 + j3 * 2;
            }
        }
        k2 = k;
        if (zzis != 0)
        {
            k2 = k + zzrx.zzA(17, zzis);
        }
        j = k2;
        if (zziq)
        {
            j = k2 + zzrx.zzc(18, zziq);
        }
        k = j;
        if (zzid != null)
        {
            k = j;
            if (zzid.length > 0)
            {
                int l2 = 0;
                int k3 = 0;
                for (k = ((flag) ? 1 : 0); k < zzid.length;)
                {
                    String s2 = zzid[k];
                    k4 = l2;
                    int j4 = k3;
                    if (s2 != null)
                    {
                        j4 = k3 + 1;
                        k4 = l2 + zzrx.zzfA(s2);
                    }
                    k++;
                    l2 = k4;
                    k3 = j4;
                }

                k = j + l2 + k3 * 2;
            }
        }
        return k;
    }

    public final  zzJ()
    {
        zzid = zzsh.zzbiC;
        zzie = zzsh.zzbiC;
        zzif = zzQ();
        zzig = zzH();
        zzih = zzC();
        zzii = zzC();
        zzij = zzC();
        zzik = zzK();
        zzil = "";
        zzim = "";
        zzin = "0";
        version = "";
        zzio = null;
        zzip = 0.0F;
        zziq = false;
        zzir = zzsh.zzbiC;
        zzis = 0;
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final void zza(zzrx zzrx1)
    {
        boolean flag = false;
        if (zzie != null && zzie.length > 0)
        {
            for (int i = 0; i < zzie.length; i++)
            {
                String s = zzie[i];
                if (s != null)
                {
                    zzrx1.zzb(1, s);
                }
            }

        }
        if (zzif != null && zzif.length > 0)
        {
            for (int j = 0; j < zzif.length; j++)
            {
                zzbiv zzbiv = zzif[j];
                if (zzbiv != null)
                {
                    zzrx1.zza(2, zzbiv);
                }
            }

        }
        if (zzig != null && zzig.length > 0)
        {
            for (int k = 0; k < zzig.length; k++)
            {
                zzbiv zzbiv1 = zzig[k];
                if (zzbiv1 != null)
                {
                    zzrx1.zza(3, zzbiv1);
                }
            }

        }
        if (zzih != null && zzih.length > 0)
        {
            for (int l = 0; l < zzih.length; l++)
            {
                zzbiv zzbiv2 = zzih[l];
                if (zzbiv2 != null)
                {
                    zzrx1.zza(4, zzbiv2);
                }
            }

        }
        if (zzii != null && zzii.length > 0)
        {
            for (int i1 = 0; i1 < zzii.length; i1++)
            {
                zzbiv zzbiv3 = zzii[i1];
                if (zzbiv3 != null)
                {
                    zzrx1.zza(5, zzbiv3);
                }
            }

        }
        if (zzij != null && zzij.length > 0)
        {
            for (int j1 = 0; j1 < zzij.length; j1++)
            {
                zzbiv zzbiv4 = zzij[j1];
                if (zzbiv4 != null)
                {
                    zzrx1.zza(6, zzbiv4);
                }
            }

        }
        if (zzik != null && zzik.length > 0)
        {
            for (int k1 = 0; k1 < zzik.length; k1++)
            {
                zzbiv zzbiv5 = zzik[k1];
                if (zzbiv5 != null)
                {
                    zzrx1.zza(7, zzbiv5);
                }
            }

        }
        if (!zzil.equals(""))
        {
            zzrx1.zzb(9, zzil);
        }
        if (!zzim.equals(""))
        {
            zzrx1.zzb(10, zzim);
        }
        if (!zzin.equals("0"))
        {
            zzrx1.zzb(12, zzin);
        }
        if (!version.equals(""))
        {
            zzrx1.zzb(13, version);
        }
        if (zzio != null)
        {
            zzrx1.zza(14, zzio);
        }
        if (Float.floatToIntBits(zzip) != Float.floatToIntBits(0.0F))
        {
            zzrx1.zzb(15, zzip);
        }
        if (zzir != null && zzir.length > 0)
        {
            for (int l1 = 0; l1 < zzir.length; l1++)
            {
                String s1 = zzir[l1];
                if (s1 != null)
                {
                    zzrx1.zzb(16, s1);
                }
            }

        }
        if (zzis != 0)
        {
            zzrx1.zzy(17, zzis);
        }
        if (zziq)
        {
            zzrx1.zzb(18, zziq);
        }
        if (zzid != null && zzid.length > 0)
        {
            for (int i2 = ((flag) ? 1 : 0); i2 < zzid.length; i2++)
            {
                String s2 = zzid[i2];
                if (s2 != null)
                {
                    zzrx1.zzb(19, s2);
                }
            }

        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzg(zzrw1);
    }

    public final zzg zzg(zzrw zzrw1)
    {
        do
        {
            int i = zzrw1.zzFo();
            switch (i)
            {
            default:
                if (zza(zzrw1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                int k2 = zzsh.zzc(zzrw1, 10);
                String as[];
                int j;
                if (zzie == null)
                {
                    j = 0;
                } else
                {
                    j = zzie.length;
                }
                as = new String[k2 + j];
                k2 = j;
                if (j != 0)
                {
                    System.arraycopy(zzie, 0, as, 0, j);
                    k2 = j;
                }
                for (; k2 < as.length - 1; k2++)
                {
                    as[k2] = zzrw1.readString();
                    zzrw1.zzFo();
                }

                as[k2] = zzrw1.readString();
                zzie = as;
                break;

            case 18: // '\022'
                int l2 = zzsh.zzc(zzrw1, 18);
                zzg azzg[];
                int k;
                if (zzif == null)
                {
                    k = 0;
                } else
                {
                    k = zzif.length;
                }
                azzg = new zzif[l2 + k];
                l2 = k;
                if (k != 0)
                {
                    System.arraycopy(zzif, 0, azzg, 0, k);
                    l2 = k;
                }
                for (; l2 < azzg.length - 1; l2++)
                {
                    azzg[l2] = new <init>();
                    zzrw1.zza(azzg[l2]);
                    zzrw1.zzFo();
                }

                azzg[l2] = new <init>();
                zzrw1.zza(azzg[l2]);
                zzif = azzg;
                break;

            case 26: // '\032'
                int i3 = zzsh.zzc(zzrw1, 26);
                zzg azzg1[];
                int l;
                if (zzig == null)
                {
                    l = 0;
                } else
                {
                    l = zzig.length;
                }
                azzg1 = new zzig[i3 + l];
                i3 = l;
                if (l != 0)
                {
                    System.arraycopy(zzig, 0, azzg1, 0, l);
                    i3 = l;
                }
                for (; i3 < azzg1.length - 1; i3++)
                {
                    azzg1[i3] = new <init>();
                    zzrw1.zza(azzg1[i3]);
                    zzrw1.zzFo();
                }

                azzg1[i3] = new <init>();
                zzrw1.zza(azzg1[i3]);
                zzig = azzg1;
                break;

            case 34: // '"'
                int j3 = zzsh.zzc(zzrw1, 34);
                zzg azzg2[];
                int i1;
                if (zzih == null)
                {
                    i1 = 0;
                } else
                {
                    i1 = zzih.length;
                }
                azzg2 = new zzih[j3 + i1];
                j3 = i1;
                if (i1 != 0)
                {
                    System.arraycopy(zzih, 0, azzg2, 0, i1);
                    j3 = i1;
                }
                for (; j3 < azzg2.length - 1; j3++)
                {
                    azzg2[j3] = new <init>();
                    zzrw1.zza(azzg2[j3]);
                    zzrw1.zzFo();
                }

                azzg2[j3] = new <init>();
                zzrw1.zza(azzg2[j3]);
                zzih = azzg2;
                break;

            case 42: // '*'
                int k3 = zzsh.zzc(zzrw1, 42);
                zzg azzg3[];
                int j1;
                if (zzii == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = zzii.length;
                }
                azzg3 = new zzii[k3 + j1];
                k3 = j1;
                if (j1 != 0)
                {
                    System.arraycopy(zzii, 0, azzg3, 0, j1);
                    k3 = j1;
                }
                for (; k3 < azzg3.length - 1; k3++)
                {
                    azzg3[k3] = new <init>();
                    zzrw1.zza(azzg3[k3]);
                    zzrw1.zzFo();
                }

                azzg3[k3] = new <init>();
                zzrw1.zza(azzg3[k3]);
                zzii = azzg3;
                break;

            case 50: // '2'
                int l3 = zzsh.zzc(zzrw1, 50);
                zzg azzg4[];
                int k1;
                if (zzij == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = zzij.length;
                }
                azzg4 = new zzij[l3 + k1];
                l3 = k1;
                if (k1 != 0)
                {
                    System.arraycopy(zzij, 0, azzg4, 0, k1);
                    l3 = k1;
                }
                for (; l3 < azzg4.length - 1; l3++)
                {
                    azzg4[l3] = new <init>();
                    zzrw1.zza(azzg4[l3]);
                    zzrw1.zzFo();
                }

                azzg4[l3] = new <init>();
                zzrw1.zza(azzg4[l3]);
                zzij = azzg4;
                break;

            case 58: // ':'
                int i4 = zzsh.zzc(zzrw1, 58);
                zzg azzg5[];
                int l1;
                if (zzik == null)
                {
                    l1 = 0;
                } else
                {
                    l1 = zzik.length;
                }
                azzg5 = new zzik[i4 + l1];
                i4 = l1;
                if (l1 != 0)
                {
                    System.arraycopy(zzik, 0, azzg5, 0, l1);
                    i4 = l1;
                }
                for (; i4 < azzg5.length - 1; i4++)
                {
                    azzg5[i4] = new <init>();
                    zzrw1.zza(azzg5[i4]);
                    zzrw1.zzFo();
                }

                azzg5[i4] = new <init>();
                zzrw1.zza(azzg5[i4]);
                zzik = azzg5;
                break;

            case 74: // 'J'
                zzil = zzrw1.readString();
                break;

            case 82: // 'R'
                zzim = zzrw1.readString();
                break;

            case 98: // 'b'
                zzin = zzrw1.readString();
                break;

            case 106: // 'j'
                version = zzrw1.readString();
                break;

            case 114: // 'r'
                if (zzio == null)
                {
                    zzio = new <init>();
                }
                zzrw1.zza(zzio);
                break;

            case 125: // '}'
                zzip = zzrw1.readFloat();
                break;

            case 130: 
                int j4 = zzsh.zzc(zzrw1, 130);
                String as1[];
                int i2;
                if (zzir == null)
                {
                    i2 = 0;
                } else
                {
                    i2 = zzir.length;
                }
                as1 = new String[j4 + i2];
                j4 = i2;
                if (i2 != 0)
                {
                    System.arraycopy(zzir, 0, as1, 0, i2);
                    j4 = i2;
                }
                for (; j4 < as1.length - 1; j4++)
                {
                    as1[j4] = zzrw1.readString();
                    zzrw1.zzFo();
                }

                as1[j4] = zzrw1.readString();
                zzir = as1;
                break;

            case 136: 
                zzis = zzrw1.zzFr();
                break;

            case 144: 
                zziq = zzrw1.zzFs();
                break;

            case 154: 
                int k4 = zzsh.zzc(zzrw1, 154);
                String as2[];
                int j2;
                if (zzid == null)
                {
                    j2 = 0;
                } else
                {
                    j2 = zzid.length;
                }
                as2 = new String[k4 + j2];
                k4 = j2;
                if (j2 != 0)
                {
                    System.arraycopy(zzid, 0, as2, 0, j2);
                    k4 = j2;
                }
                for (; k4 < as2.length - 1; k4++)
                {
                    as2[k4] = zzrw1.readString();
                    zzrw1.zzFo();
                }

                as2[k4] = zzrw1.readString();
                zzid = as2;
                break;
            }
        } while (true);
    }

    public ()
    {
        zzJ();
    }
}
