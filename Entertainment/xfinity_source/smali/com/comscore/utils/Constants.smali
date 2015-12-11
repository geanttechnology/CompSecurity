.class public Lcom/comscore/utils/Constants;
.super Ljava/lang/Object;


# static fields
.field public static DEBUG:Z

.field public static final LABELS_ORDER:[Ljava/lang/String;

.field public static final RSA_PUBLIC_KEY:[B


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v2, 0x0

    sput-boolean v2, Lcom/comscore/utils/Constants;->DEBUG:Z

    const/16 v0, 0xa2

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lcom/comscore/utils/Constants;->RSA_PUBLIC_KEY:[B

    const/16 v0, 0x6b

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "c1"

    aput-object v1, v0, v2

    const/4 v1, 0x1

    const-string v2, "c2"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "ns_site"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "ns_vsite"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "ns_ap_an"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "ns_ap_pv"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "ns_ap_pn"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "c12"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "name"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "ns_ak"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "ns_ap_ec"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "ns_ap_ev"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "ns_ap_device"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "ns_ap_id"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "ns_ap_csf"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "ns_ap_bi"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "ns_ap_pfm"

    aput-object v2, v0, v1

    const/16 v1, 0x11

    const-string v2, "ns_ap_pfv"

    aput-object v2, v0, v1

    const/16 v1, 0x12

    const-string v2, "ns_ap_ver"

    aput-object v2, v0, v1

    const/16 v1, 0x13

    const-string v2, "ns_ap_sv"

    aput-object v2, v0, v1

    const/16 v1, 0x14

    const-string v2, "ns_type"

    aput-object v2, v0, v1

    const/16 v1, 0x15

    const-string v2, "ns_radio"

    aput-object v2, v0, v1

    const/16 v1, 0x16

    const-string v2, "ns_nc"

    aput-object v2, v0, v1

    const/16 v1, 0x17

    const-string v2, "ns_ap_ui"

    aput-object v2, v0, v1

    const/16 v1, 0x18

    const-string v2, "ns_ap_gs"

    aput-object v2, v0, v1

    const/16 v1, 0x19

    const-string v2, "ns_st_sv"

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    const-string v2, "ns_st_pv"

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    const-string v2, "ns_st_it"

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    const-string v2, "ns_st_id"

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    const-string v2, "ns_st_ec"

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    const-string v2, "ns_st_sp"

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    const-string v2, "ns_st_sq"

    aput-object v2, v0, v1

    const/16 v1, 0x20

    const-string v2, "ns_st_cn"

    aput-object v2, v0, v1

    const/16 v1, 0x21

    const-string v2, "ns_st_ev"

    aput-object v2, v0, v1

    const/16 v1, 0x22

    const-string v2, "ns_st_po"

    aput-object v2, v0, v1

    const/16 v1, 0x23

    const-string v2, "ns_st_cl"

    aput-object v2, v0, v1

    const/16 v1, 0x24

    const-string v2, "ns_st_el"

    aput-object v2, v0, v1

    const/16 v1, 0x25

    const-string v2, "ns_st_pb"

    aput-object v2, v0, v1

    const/16 v1, 0x26

    const-string v2, "ns_st_hc"

    aput-object v2, v0, v1

    const/16 v1, 0x27

    const-string v2, "ns_st_mp"

    aput-object v2, v0, v1

    const/16 v1, 0x28

    const-string v2, "ns_st_mv"

    aput-object v2, v0, v1

    const/16 v1, 0x29

    const-string v2, "ns_st_pn"

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    const-string v2, "ns_st_tp"

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    const-string v2, "ns_st_pt"

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    const-string v2, "ns_st_pa"

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    const-string v2, "ns_st_ad"

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    const-string v2, "ns_st_li"

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    const-string v2, "ns_st_ci"

    aput-object v2, v0, v1

    const/16 v1, 0x30

    const-string v2, "ns_ap_jb"

    aput-object v2, v0, v1

    const/16 v1, 0x31

    const-string v2, "ns_ap_res"

    aput-object v2, v0, v1

    const/16 v1, 0x32

    const-string v2, "ns_ap_c12m"

    aput-object v2, v0, v1

    const/16 v1, 0x33

    const-string v2, "ns_ap_install"

    aput-object v2, v0, v1

    const/16 v1, 0x34

    const-string v2, "ns_ap_updated"

    aput-object v2, v0, v1

    const/16 v1, 0x35

    const-string v2, "ns_ap_lastrun"

    aput-object v2, v0, v1

    const/16 v1, 0x36

    const-string v2, "ns_ap_cs"

    aput-object v2, v0, v1

    const/16 v1, 0x37

    const-string v2, "ns_ap_runs"

    aput-object v2, v0, v1

    const/16 v1, 0x38

    const-string v2, "ns_ap_usage"

    aput-object v2, v0, v1

    const/16 v1, 0x39

    const-string v2, "ns_ap_fg"

    aput-object v2, v0, v1

    const/16 v1, 0x3a

    const-string v2, "ns_ap_ft"

    aput-object v2, v0, v1

    const/16 v1, 0x3b

    const-string v2, "ns_ap_dft"

    aput-object v2, v0, v1

    const/16 v1, 0x3c

    const-string v2, "ns_ap_bt"

    aput-object v2, v0, v1

    const/16 v1, 0x3d

    const-string v2, "ns_ap_dbt"

    aput-object v2, v0, v1

    const/16 v1, 0x3e

    const-string v2, "ns_ap_dit"

    aput-object v2, v0, v1

    const/16 v1, 0x3f

    const-string v2, "ns_ap_as"

    aput-object v2, v0, v1

    const/16 v1, 0x40

    const-string v2, "ns_ap_das"

    aput-object v2, v0, v1

    const/16 v1, 0x41

    const-string v2, "ns_ap_it"

    aput-object v2, v0, v1

    const/16 v1, 0x42

    const-string v2, "ns_ap_uc"

    aput-object v2, v0, v1

    const/16 v1, 0x43

    const-string v2, "ns_ap_aus"

    aput-object v2, v0, v1

    const/16 v1, 0x44

    const-string v2, "ns_ap_daus"

    aput-object v2, v0, v1

    const/16 v1, 0x45

    const-string v2, "ns_ap_us"

    aput-object v2, v0, v1

    const/16 v1, 0x46

    const-string v2, "ns_ap_dus"

    aput-object v2, v0, v1

    const/16 v1, 0x47

    const-string v2, "ns_ap_ut"

    aput-object v2, v0, v1

    const/16 v1, 0x48

    const-string v2, "ns_ap_oc"

    aput-object v2, v0, v1

    const/16 v1, 0x49

    const-string v2, "ns_ap_uxc"

    aput-object v2, v0, v1

    const/16 v1, 0x4a

    const-string v2, "ns_ap_uxs"

    aput-object v2, v0, v1

    const/16 v1, 0x4b

    const-string v2, "ns_ap_lang"

    aput-object v2, v0, v1

    const/16 v1, 0x4c

    const-string v2, "ns_ap_miss"

    aput-object v2, v0, v1

    const/16 v1, 0x4d

    const-string v2, "ns_ts"

    aput-object v2, v0, v1

    const/16 v1, 0x4e

    const-string v2, "ns_st_ca"

    aput-object v2, v0, v1

    const/16 v1, 0x4f

    const-string v2, "ns_st_cp"

    aput-object v2, v0, v1

    const/16 v1, 0x50

    const-string v2, "ns_st_er"

    aput-object v2, v0, v1

    const/16 v1, 0x51

    const-string v2, "ns_st_pe"

    aput-object v2, v0, v1

    const/16 v1, 0x52

    const-string v2, "ns_st_ui"

    aput-object v2, v0, v1

    const/16 v1, 0x53

    const-string v2, "ns_st_bc"

    aput-object v2, v0, v1

    const/16 v1, 0x54

    const-string v2, "ns_st_bt"

    aput-object v2, v0, v1

    const/16 v1, 0x55

    const-string v2, "ns_st_bp"

    aput-object v2, v0, v1

    const/16 v1, 0x56

    const-string v2, "ns_st_pc"

    aput-object v2, v0, v1

    const/16 v1, 0x57

    const-string v2, "ns_st_pp"

    aput-object v2, v0, v1

    const/16 v1, 0x58

    const-string v2, "ns_st_br"

    aput-object v2, v0, v1

    const/16 v1, 0x59

    const-string v2, "ns_st_ub"

    aput-object v2, v0, v1

    const/16 v1, 0x5a

    const-string v2, "ns_st_vo"

    aput-object v2, v0, v1

    const/16 v1, 0x5b

    const-string v2, "ns_st_ws"

    aput-object v2, v0, v1

    const/16 v1, 0x5c

    const-string v2, "ns_st_pl"

    aput-object v2, v0, v1

    const/16 v1, 0x5d

    const-string v2, "ns_st_pr"

    aput-object v2, v0, v1

    const/16 v1, 0x5e

    const-string v2, "ns_st_ep"

    aput-object v2, v0, v1

    const/16 v1, 0x5f

    const-string v2, "ns_st_ty"

    aput-object v2, v0, v1

    const/16 v1, 0x60

    const-string v2, "ns_st_cs"

    aput-object v2, v0, v1

    const/16 v1, 0x61

    const-string v2, "ns_st_ge"

    aput-object v2, v0, v1

    const/16 v1, 0x62

    const-string v2, "ns_st_st"

    aput-object v2, v0, v1

    const/16 v1, 0x63

    const-string v2, "ns_st_dt"

    aput-object v2, v0, v1

    const/16 v1, 0x64

    const-string v2, "ns_st_ct"

    aput-object v2, v0, v1

    const/16 v1, 0x65

    const-string v2, "ns_st_de"

    aput-object v2, v0, v1

    const/16 v1, 0x66

    const-string v2, "ns_st_pu"

    aput-object v2, v0, v1

    const/16 v1, 0x67

    const-string v2, "ns_st_cu"

    aput-object v2, v0, v1

    const/16 v1, 0x68

    const-string v2, "ns_st_fee"

    aput-object v2, v0, v1

    const/16 v1, 0x69

    const-string v2, "c7"

    aput-object v2, v0, v1

    const/16 v1, 0x6a

    const-string v2, "c9"

    aput-object v2, v0, v1

    sput-object v0, Lcom/comscore/utils/Constants;->LABELS_ORDER:[Ljava/lang/String;

    return-void

    :array_0
    .array-data 1
        0x30t
        -0x7ft
        -0x61t
        0x30t
        0xdt
        0x6t
        0x9t
        0x2at
        -0x7at
        0x48t
        -0x7at
        -0x9t
        0xdt
        0x1t
        0x1t
        0x1t
        0x5t
        0x0t
        0x3t
        -0x7ft
        -0x73t
        0x0t
        0x30t
        -0x7ft
        -0x77t
        0x2t
        -0x7ft
        -0x7ft
        0x0t
        -0xct
        -0x7t
        -0x10t
        -0x6bt
        -0x3ct
        0x6at
        -0x49t
        0x6t
        0x4dt
        -0x48t
        -0x73t
        0x42t
        -0x72t
        -0x2ct
        -0x4t
        -0x14t
        -0x77t
        0x4bt
        0x37t
        -0x42t
        -0x54t
        0x30t
        -0x15t
        0x34t
        0x78t
        -0x61t
        0x67t
        -0x49t
        0x3t
        0x7t
        -0x6bt
        0x2dt
        0x40t
        0x20t
        -0x4et
        -0x50t
        -0x2ft
        0x6ct
        0x5t
        -0x77t
        -0x4t
        0x48t
        -0x27t
        -0x65t
        0x55t
        -0x7ft
        0x2ct
        0x15t
        0x4dt
        0x32t
        0x24t
        -0x35t
        -0x5bt
        0x20t
        0x24t
        0x57t
        -0x55t
        0x23t
        0x38t
        -0x76t
        -0x2ct
        -0x4dt
        0x4dt
        -0xft
        0x75t
        0x41t
        0x23t
        0x41t
        -0x6et
        0x47t
        -0x40t
        -0x1ft
        -0x76t
        -0x8t
        -0x39t
        -0xdt
        0x15t
        -0x5at
        0x6et
        -0x6et
        -0x76t
        0x34t
        -0x58t
        0xbt
        0x4t
        0x30t
        -0x4t
        0x10t
        -0x1at
        -0x66t
        0x2ct
        -0x41t
        0x42t
        0x5dt
        -0x70t
        0x17t
        0x54t
        0x1at
        0x12t
        -0x64t
        -0x7ct
        -0x7t
        0x3at
        -0x8t
        -0x2at
        0x26t
        0xft
        -0x5ft
        -0x25t
        -0x1dt
        -0x7et
        -0x1ct
        -0x59t
        -0x41t
        -0x26t
        0x42t
        0x75t
        0x5et
        0x5bt
        0x3bt
        -0x21t
        0x0t
        -0xct
        0x32t
        0x4ct
        -0x6ct
        0x79t
        -0x3ft
        0x2t
        0x3t
        0x1t
        0x0t
        0x1t
    .end array-data
.end method
