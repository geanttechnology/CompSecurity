.class public final Lcn/jpush/android/util/a;
.super Ljava/lang/Object;


# static fields
.field public static a:I

.field private static b:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final c:Ljavax/security/auth/x500/X500Principal;

.field private static final d:Ljava/lang/String;

.field private static final e:Ljava/lang/String;

.field private static final f:Ljava/lang/String;

.field private static final g:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final h:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static final i:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static j:Lcn/jpush/android/service/PushReceiver;

.field private static final z:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 10

    const/4 v4, 0x2

    const/4 v5, 0x7

    const/4 v1, -0x1

    const/4 v2, 0x0

    const/4 v3, 0x1

    const/16 v0, 0x82

    new-array v6, v0, [Ljava/lang/String;

    const-string v0, "^k.*ZGj9"

    move v7, v2

    move-object v8, v6

    move-object v9, v6

    move-object v6, v0

    move v0, v1

    :goto_0
    invoke-static {v6}, Lcn/jpush/android/util/a;->z(Ljava/lang/String;)[C

    move-result-object v6

    invoke-static {v6}, Lcn/jpush/android/util/a;->z([C)Ljava/lang/String;

    move-result-object v6

    packed-switch v0, :pswitch_data_0

    aput-object v6, v8, v7

    const-string v0, "Fo1\u0010"

    move-object v6, v0

    move v7, v3

    move-object v8, v9

    move v0, v2

    goto :goto_0

    :pswitch_0
    aput-object v6, v8, v7

    const-string v0, "Xe;"

    move-object v6, v0

    move v7, v4

    move-object v8, v9

    move v0, v3

    goto :goto_0

    :pswitch_1
    aput-object v6, v8, v7

    const/4 v6, 0x3

    const-string v0, "^k.*WIc9"

    move v7, v6

    move-object v8, v9

    move-object v6, v0

    move v0, v4

    goto :goto_0

    :pswitch_2
    aput-object v6, v8, v7

    const/4 v7, 0x4

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Im(\u001cVF \u00114pf"

    const/4 v0, 0x3

    move-object v8, v9

    goto :goto_0

    :pswitch_3
    aput-object v6, v8, v7

    const/4 v7, 0x5

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Ko(\u0010^G|%[ui[\u00126qm\\"

    const/4 v0, 0x4

    move-object v8, v9

    goto :goto_0

    :pswitch_4
    aput-object v6, v8, v7

    const/4 v7, 0x6

    const-string v6, "Ka2\u001b\\Kz5\u0003P\\w"

    const/4 v0, 0x5

    move-object v8, v9

    goto :goto_0

    :pswitch_5
    aput-object v6, v8, v7

    const-string v6, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[nzG\u00080fmV\u00080kfO\u0010*j|A\u000e4~m"

    const/4 v0, 0x6

    move v7, v5

    move-object v8, v9

    goto :goto_0

    :pswitch_6
    aput-object v6, v8, v7

    const/16 v6, 0x8

    const-string v0, "Mc,\u0001@\u0008~=\u0007XE}"

    move v7, v6

    move-object v8, v9

    move-object v6, v0

    move v0, v5

    goto :goto_0

    :pswitch_7
    aput-object v6, v8, v7

    const/16 v7, 0x9

    const-string v6, "oa(UJLm=\u0007]\u0008h5\u0019\\\u0008}=\u0003\\L.8\u0010OAm9<]\u0008#|"

    const/16 v0, 0x8

    move-object v8, v9

    goto :goto_0

    :pswitch_8
    aput-object v6, v8, v7

    const/16 v7, 0xa

    const-string v6, "Kf=\u001bWMb"

    const/16 v0, 0x9

    move-object v8, v9

    goto :goto_0

    :pswitch_9
    aput-object v6, v8, v7

    const/16 v7, 0xb

    const-string v6, "Lk*\u001cZM"

    const/16 v0, 0xa

    move-object v8, v9

    goto :goto_0

    :pswitch_a
    aput-object v6, v8, v7

    const/16 v7, 0xc

    const-string v6, "I`8\u0007VAj\u000f\u0011R~k.\u0006PG`"

    const/16 v0, 0xb

    move-object v8, v9

    goto :goto_0

    :pswitch_b
    aput-object v6, v8, v7

    const/16 v7, 0xd

    const-string v6, "Ea8\u0010U"

    const/16 v0, 0xc

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_c
    aput-object v6, v8, v7

    const/16 v7, 0xe

    const-string v6, "Jo/\u0010[I`8"

    const/16 v0, 0xd

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_d
    aput-object v6, v8, v7

    const/16 v7, 0xf

    const-string v6, "Fk(\u0002VZe"

    const/16 v0, 0xe

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_e
    aput-object v6, v8, v7

    const/16 v7, 0x10

    const-string v6, "]|0"

    const/16 v0, 0xf

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_f
    aput-object v6, v8, v7

    const/16 v7, 0x11

    const-string v6, "O}1[OM|/\u001cVF >\u0014JMl=\u001b]"

    const/16 v0, 0x10

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_10
    aput-object v6, v8, v7

    const/16 v7, 0x12

    const-string v6, "Xf3\u001b\\"

    const/16 v0, 0x11

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_11
    aput-object v6, v8, v7

    const/16 v7, 0x13

    const-string v6, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[kmO\u0018*i`A\u00120f{Z\u001d!|"

    const/16 v0, 0x12

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_12
    aput-object v6, v8, v7

    const/16 v7, 0x14

    const-string v6, "Kb3\u0006\\X{/\u001d"

    const/16 v0, 0x13

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_13
    aput-object v6, v8, v7

    const/16 v7, 0x15

    const-string v6, "X{/\u001d\u0019\\g1\u0010\u0019A}|\uff6f"

    const/16 v0, 0x14

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_14
    aput-object v6, v8, v7

    const/16 v7, 0x16

    const-string v6, "tP"

    const/16 v0, 0x15

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_15
    aput-object v6, v8, v7

    const/16 v7, 0x17

    const-string v6, "X{/\u001dMAc9"

    const/16 v0, 0x16

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_16
    aput-object v6, v8, v7

    const/16 v7, 0x18

    const-string v6, "og*\u0010\u0019]~|\u0001V\u0008}(\u0014K\\.=\u0005I\u0008h3\u0007\u0019A`*\u0014UAj|\u0005XZo1\u0006\u0019\u0005.,\u0014ZCo;\u0010wIc9O"

    const/16 v0, 0x17

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_17
    aput-object v6, v8, v7

    const/16 v7, 0x19

    const-string v6, "f[\u00109\u0019Ka2\u0001\\Pz"

    const/16 v0, 0x18

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_18
    aput-object v6, v8, v7

    const/16 v7, 0x1a

    const-string v6, "zk0\u0010X[k|\u0002XCk|\u0019VKe|\u0014_\\k.U\u000c\u0018>l\u0018J\u0012"

    const/16 v0, 0x19

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_19
    aput-object v6, v8, v7

    const/16 v7, 0x1b

    const-string v6, "eJi"

    const/16 v0, 0x1a

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_1a
    aput-object v6, v8, v7

    const/16 v7, 0x1c

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Im(\u001cVF \n<|\u007f"

    const/16 v0, 0x1b

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_1b
    aput-object v6, v8, v7

    const/16 v7, 0x1d

    const-string v6, "I~,\u0019PKo(\u001cVF!*\u001b]\u0006o2\u0011KGg8[IIm7\u0014^M#=\u0007Z@g*\u0010"

    const/16 v0, 0x1c

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_1c
    aput-object v6, v8, v7

    const/16 v7, 0x1e

    const-string v6, "\u001ci"

    const/16 v0, 0x1d

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_1d
    aput-object v6, v8, v7

    const/16 v7, 0x1f

    const-string v6, "\u001bi"

    const/16 v0, 0x1e

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_1e
    aput-object v6, v8, v7

    const/16 v7, 0x20

    const-string v6, "_g:\u001c"

    const/16 v0, 0x1f

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_1f
    aput-object v6, v8, v7

    const/16 v7, 0x21

    const-string v6, "F{0\u0019"

    const/16 v0, 0x20

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_20
    aput-object v6, v8, v7

    const/16 v7, 0x22

    const-string v6, "\u001ai"

    const/16 v0, 0x21

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_21
    aput-object v6, v8, v7

    const/16 v7, 0x23

    const-string v6, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[nzG\u00080f{K\u0008!pfI\u000f"

    const/16 v0, 0x22

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_22
    aput-object v6, v8, v7

    const/16 v7, 0x24

    const-string v6, "b^)\u0006QwJ9\u0003PKk\u0015\u0011"

    const/16 v0, 0x23

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_23
    aput-object v6, v8, v7

    const/16 v7, 0x25

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL \u0019-mzO"

    const/16 v0, 0x24

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_24
    aput-object v6, v8, v7

    const/16 v7, 0x26

    const-string v6, "ko2UWGz|\u0012\\\\.,\u0014ZCo;\u0010\u0019Fo1\u0010\u0017"

    const/16 v0, 0x25

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_25
    aput-object v6, v8, v7

    const/16 v7, 0x27

    const-string v6, "i`8\u0007VAj\t\u0001PD"

    const/16 v0, 0x26

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_26
    aput-object v6, v8, v7

    const/16 v7, 0x28

    const-string v6, "\r}r\u0005\\Zc5\u0006JAa2[sx[\u000f=feK\u000f&xoK"

    const/16 v0, 0x27

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_27
    aput-object v6, v8, v7

    const/16 v7, 0x29

    const-string v6, "Xb)\u0012^Mj"

    const/16 v0, 0x28

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_28
    aput-object v6, v8, v7

    const/16 v7, 0x2a

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Im(\u001cVF \u001e4m|K\u000e,fkF\u001d;~mJ"

    const/16 v0, 0x29

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_29
    aput-object v6, v8, v7

    const/16 v7, 0x2b

    const-string v6, "[z=\u0001L["

    const/16 v0, 0x2a

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_2a
    aput-object v6, v8, v7

    const/16 v7, 0x2c

    const-string v6, "Lk>\u0000^w`3\u0001PNg?\u0014MAa2"

    const/16 v0, 0x2b

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_2b
    aput-object v6, v8, v7

    const/16 v7, 0x2d

    const-string v6, "b^)\u0006Q\u63f8\u7934\uff46\u7f4f\u5c28\u7ef7\u8baf\u4ebf\u7874"

    const/16 v0, 0x2c

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_2c
    aput-object v6, v8, v7

    const/16 v7, 0x2e

    const-string v6, "\\w,\u0010"

    const/16 v0, 0x2d

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_2d
    aput-object v6, v8, v7

    const/16 v7, 0x2f

    const-string v6, "Fa(\u001c_Am=\u0001PG`"

    const/16 v0, 0x2e

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_2e
    aput-object v6, v8, v7

    const/16 v7, 0x30

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL 5\u001bMM`([wgZ\u00153pkO\u0008<vfQ\u0013%|fK\u0018*izA\u0004,"

    const/16 v0, 0x2f

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_2f
    aput-object v6, v8, v7

    const/16 v7, 0x31

    const-string v6, "\u68e8\u6d45\u526c\u96b3\u6229\u0008]\u0018>\u0019\u6702\u6df5\u52fc\u7eaa\u8b98\u4ecb\u780f\u305e\u70cc\u51c2\u67cd\u7705\u8bba\u60b0"

    const/16 v0, 0x30

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_30
    aput-object v6, v8, v7

    const/16 v7, 0x32

    const-string v6, "Im(\u001cOAz%"

    const/16 v0, 0x31

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_31
    aput-object v6, v8, v7

    const/16 v7, 0x33

    const-string v6, "aC\u0019<"

    const/16 v0, 0x32

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_32
    aput-object v6, v8, v7

    const/16 v7, 0x34

    const-string v6, "oa(UJLm=\u0007]\u0008h5\u0019\\\u0008}=\u0003\\L.)\u0011PL.qU"

    const/16 v0, 0x33

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_33
    aput-object v6, v8, v7

    const/16 v7, 0x35

    const-string v6, "x|9\u0013Jng0\u0010"

    const/16 v0, 0x34

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_34
    aput-object v6, v8, v7

    const/16 v7, 0x36

    const-string v6, "X{/\u001df]j5\u0011"

    const/16 v0, 0x35

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_35
    aput-object v6, v8, v7

    const/16 v7, 0x37

    const-string v6, "Ck%"

    const/16 v0, 0x36

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_36
    aput-object v6, v8, v7

    const/16 v7, 0x38

    const-string v6, "Xa+\u0010K"

    const/16 v0, 0x37

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_37
    aput-object v6, v8, v7

    const/16 v7, 0x39

    const-string v6, "x{/\u001d"

    const/16 v0, 0x38

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_38
    aput-object v6, v8, v7

    const/16 v7, 0x3a

    const-string v6, "Lo(\u0014"

    const/16 v0, 0x39

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_39
    aput-object v6, v8, v7

    const/16 v7, 0x3b

    const-string v6, "Az5\u0018\\"

    const/16 v0, 0x3a

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_3a
    aput-object v6, v8, v7

    const/16 v7, 0x3c

    const-string v6, "b^\t&qwO\u000c%rmW"

    const/16 v0, 0x3b

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_3b
    aput-object v6, v8, v7

    const/16 v7, 0x3d

    const-string v6, "\u00119kA]\u001d88C\u0001\u001akiA\u0000K"

    const/16 v0, 0x3c

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_3c
    aput-object v6, v8, v7

    const/16 v7, 0x3e

    const-string v6, "p iE\u0000"

    const/16 v0, 0x3d

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_3d
    aput-object v6, v8, v7

    const/16 v7, 0x3f

    const-string v6, "ok2\u0010KIz9U}Mx5\u0016\\aj|\u0006LKm9\u0006J\u0008"

    const/16 v0, 0x3e

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_3e
    aput-object v6, v8, v7

    const/16 v7, 0x40

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL 5\u001bMM`([wgZ\u00153pkO\u0008<vfQ\u000e0zmG\n0}w^\u000e:aq"

    const/16 v0, 0x3f

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_3f
    aput-object v6, v8, v7

    const/16 v7, 0x41

    const-string v6, "I`8\u0007VAjr\u001b\\\\ ?\u001aWF \u001f:wfK\u001f!p~G\u0008,fkF\u001d;~m"

    const/16 v0, 0x40

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_40
    aput-object v6, v8, v7

    const/16 v7, 0x42

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Im(\u001cVF \u000c4zcO\u001b0fzK\u0011:omJ"

    const/16 v0, 0x41

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_41
    aput-object v6, v8, v7

    const/16 v7, 0x43

    const-string v6, "Xo?\u001eXOk"

    const/16 v0, 0x42

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_42
    aput-object v6, v8, v7

    const/16 v7, 0x44

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Im(\u001cVF \t&|zQ\u000c\'|{K\u0012!"

    const/16 v0, 0x43

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_43
    aput-object v6, v8, v7

    const/16 v7, 0x45

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Im(\u001cVF \u000c4zcO\u001b0fiJ\u00180}"

    const/16 v0, 0x44

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_44
    aput-object v6, v8, v7

    const/16 v7, 0x46

    const-string v6, "eo5\u001b\u0019Kb=\u0006J\u0008g/U"

    const/16 v0, 0x45

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_45
    aput-object v6, v8, v7

    const/16 v7, 0x47

    const-string v6, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[xkM\u0019&jwY\u00153pw]\u00084mm"

    const/16 v0, 0x46

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_46
    aput-object v6, v8, v7

    const/16 v7, 0x48

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL )\u001c\u0017x{/\u001dxKz5\u0003P\\w"

    const/16 v0, 0x47

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_47
    aput-object v6, v8, v7

    const/16 v7, 0x49

    const-string v6, "Ja8\u000c"

    const/16 v0, 0x48

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_48
    aput-object v6, v8, v7

    const/16 v7, 0x4a

    const-string v6, "A}\t\u0005]Iz9#\\Z}5\u001aW"

    const/16 v0, 0x49

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_49
    aput-object v6, v8, v7

    const/16 v7, 0x4b

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL \u001d%icK\u0005"

    const/16 v0, 0x4a

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_4a
    aput-object v6, v8, v7

    const/16 v7, 0x4c

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL 5\u001bMM`([tm]\u000f4~mQ\u000e0zmG\n0}"

    const/16 v0, 0x4b

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_4b
    aput-object v6, v8, v7

    const/16 v7, 0x4d

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL \u00110j{O\u001b0"

    const/16 v0, 0x4c

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_4c
    aput-object v6, v8, v7

    const/16 v7, 0x4e

    const-string v6, "{k2\u0011\u0019J|3\u0014]Ko/\u0001\u0019\\a|\u0014IX4|"

    const/16 v0, 0x4d

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_4d
    aput-object v6, v8, v7

    const/16 v7, 0x4f

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL \u0011&~wG\u0018"

    const/16 v0, 0x4e

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_4e
    aput-object v6, v8, v7

    const/16 v7, 0x50

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL \u001f:w|K\u0012!f|W\u000c0"

    const/16 v0, 0x4f

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_4f
    aput-object v6, v8, v7

    const/16 v7, 0x51

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL \u001a<umQ\u000c4m`"

    const/16 v0, 0x50

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_50
    aput-object v6, v8, v7

    const/16 v7, 0x52

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL \u0008<mdK"

    const/16 v0, 0x51

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_51
    aput-object v6, v8, v7

    const/16 v7, 0x53

    const-string v6, "}`7\u001bV_`"

    const/16 v0, 0x52

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_52
    aput-object v6, v8, v7

    const/16 v7, 0x54

    const-string v6, "]z:X\u0001"

    const/16 v0, 0x53

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_53
    aput-object v6, v8, v7

    const/16 v7, 0x55

    const-string v6, "Ea)\u001bMMj"

    const/16 v0, 0x54

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_54
    aput-object v6, v8, v7

    const/16 v7, 0x56

    const-string v6, "I`8\u0007VAj\u0003\u001c]"

    const/16 v0, 0x55

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_55
    aput-object v6, v8, v7

    const/16 v7, 0x57

    const-string v6, "\u0007~.\u001aZ\u0007m,\u0000PFh3"

    const/16 v0, 0x56

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_56
    aput-object v6, v8, v7

    const/16 v7, 0x58

    const-string v6, "x|3\u0016\\[}3\u0007"

    const/16 v0, 0x57

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_57
    aput-object v6, v8, v7

    const/16 v7, 0x59

    const-string v6, "\\a=\u0006M|k$\u0001"

    const/16 v0, 0x58

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_58
    aput-object v6, v8, v7

    const/16 v7, 0x5a

    const-string v6, "b^)\u0006Q\u63f8\u7934\uff46\u5370\u5434\u54a4O,\u0005rMw\u4e51\u534c\u9174"

    const/16 v0, 0x59

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_59
    aput-object v6, v8, v7

    const/16 v7, 0x5b

    const-string v6, "\u8bdf\u523e|%VZz=\u0019\u0019\u4e22\u83b9\u538a\u60dd\u76bd\u532d\u5403\u54d04IXE9\u000c\u5e4f\u66dc\u65be\u001d\u001b]Za5\u0011tI`5\u0013\\[z\u76a4\u5ee1\u5b6e\u6b9d"

    const/16 v0, 0x5a

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_5a
    aput-object v6, v8, v7

    const/16 v7, 0x5c

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Mv(\u0007X\u0006}4\u001aK\\m)\u0001\u0017a@\u00080w|"

    const/16 v0, 0x5b

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_5b
    aput-object v6, v8, v7

    const/16 v7, 0x5d

    const-string v6, "Ka1[XFj.\u001aPL 0\u0014LFm4\u0010K\u0006o?\u0001PG`r<w{Z\u001d9uw]\u0014:k|M\t!"

    const/16 v0, 0x5c

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_5c
    aput-object v6, v8, v7

    const/16 v7, 0x5e

    const-string v6, "}`9\rIMm(\u0010]\u0012.5\u001bOIb5\u0011\u0019]|0U\u0014\u0008"

    const/16 v0, 0x5d

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_5d
    aput-object v6, v8, v7

    const/16 v7, 0x5f

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Mv(\u0007X\u0006}4\u001aK\\m)\u0001\u0017aM\u0013;fzK\u000f:lzM\u0019"

    const/16 v0, 0x5e

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_5e
    aput-object v6, v8, v7

    const/16 v7, 0x60

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Mv(\u0007X\u0006}4\u001aK\\m)\u0001\u0017fO\u00110"

    const/16 v0, 0x5f

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_5f
    aput-object v6, v8, v7

    const/16 v7, 0x61

    const-string v6, "L{,\u0019PKo(\u0010"

    const/16 v0, 0x60

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_60
    aput-object v6, v8, v7

    const/16 v7, 0x62

    const-string v6, "Zk;\u001cJ\\|=\u0001PG`\u0003\u001c]"

    const/16 v0, 0x61

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_61
    aput-object v6, v8, v7

    const/16 v7, 0x63

    const-string v6, "\u0018$l"

    const/16 v0, 0x62

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_62
    aput-object v6, v8, v7

    const/16 v7, 0x64

    const-string v6, "\u000c*"

    const/16 v0, 0x63

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_63
    aput-object v6, v8, v7

    const/16 v7, 0x65

    const-string v6, "k{.\u0007\\Fz|\u0005R\u0008g2\u0006MIb0\u0010]\u0008~=\u0001Q\u0012."

    const/16 v0, 0x64

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_64
    aput-object v6, v8, v7

    const/16 v7, 0x66

    const-string v6, "\u0007}%\u0006MMcs\u0014IX!"

    const/16 v0, 0x65

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_65
    aput-object v6, v8, v7

    const/16 v7, 0x67

    const-string v6, "\u0007j=\u0001X\u0007o,\u0005\u0016"

    const/16 v0, 0x66

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_66
    aput-object v6, v8, v7

    const/16 v7, 0x68

    const-string v6, "Ac9\u001c"

    const/16 v0, 0x67

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_67
    aput-object v6, v8, v7

    const/16 v7, 0x69

    const-string v6, "eO\u001fUXLj.UPFh3X\u0014\u0005#|"

    const/16 v0, 0x68

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_68
    aput-object v6, v8, v7

    const/16 v7, 0x6a

    const-string v6, "[z=\u0007Meg2\u0006"

    const/16 v0, 0x69

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_69
    aput-object v6, v8, v7

    const/16 v7, 0x6b

    const-string v6, "M`8\u0001tA`/"

    const/16 v0, 0x6a

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_6a
    aput-object v6, v8, v7

    const/16 v7, 0x6c

    const-string v6, "M`8=V]|"

    const/16 v0, 0x6b

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_6b
    aput-object v6, v8, v7

    const/16 v7, 0x6d

    const-string v6, "[z=\u0007M`a)\u0007"

    const/16 v0, 0x6c

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_6c
    aput-object v6, v8, v7

    const/16 v7, 0x6e

    const-string v6, "[g0\u0010WKk\u000c\u0000J@Z5\u0018\\"

    const/16 v0, 0x6d

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_6d
    aput-object v6, v8, v7

    const/16 v7, 0x6f

    const-string v6, "lk*\u0010UG~9\u0007\u0019[f3\u0000UL./\u0010M\u0008O,\u0005rMw|\u001cW\u0008O2\u0011KGg88XFg:\u0010J\\ $\u0018U"

    const/16 v0, 0x6e

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_6e
    aput-object v6, v8, v7

    const/16 v7, 0x70

    const-string v6, "i`8\u0007VAj\u0011\u0014WAh9\u0006M\u0006v1\u0019\u0019Eg/\u0006PFi|\u0007\\Y{5\u0007\\L./\u0010K^g?\u0010\u0003\u0008"

    const/16 v0, 0x6f

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_6f
    aput-object v6, v8, v7

    const/16 v7, 0x71

    const-string v6, "|f9UIM|1\u001cJ[a5\u001b\u0019A}|\u0007\\Y{5\u0007\\L.qU"

    const/16 v0, 0x70

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_70
    aput-object v6, v8, v7

    const/16 v7, 0x72

    const-string v6, "|f9UIM|1\u001cJ[a5\u001b\u0019A}|\u0007\\Y{5\u0007\\L.qUXFj.\u001aPL ,\u0010KEg/\u0006PG`r\"kaZ\u0019*jmZ\u0008<wo]"

    const/16 v0, 0x71

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_71
    aput-object v6, v8, v7

    const/16 v7, 0x73

    const-string v6, "Im(\u001cVF4?\u001d\\Ke\n\u0014UAj\u0011\u0014WAh9\u0006M"

    const/16 v0, 0x72

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_72
    aput-object v6, v8, v7

    const/16 v7, 0x74

    const-string v6, "i`8\u0007VAj\u0011\u0014WAh9\u0006M\u0006v1\u0019\u0019Eg/\u0006PFi|\u0007\\Y{5\u0007\\L..\u0010ZMg*\u0010K\u0012."

    const/16 v0, 0x73

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_73
    aput-object v6, v8, v7

    const/16 v7, 0x75

    const-string v6, "I`8\u0007VAjr\u001cW\\k2\u0001\u0017Im(\u001cVF \u001e:v|Q\u001f:txB\u0019!|l"

    const/16 v0, 0x74

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_74
    aput-object v6, v8, v7

    const/16 v7, 0x76

    const-string v6, "i`8\u0007VAj\u0011\u0014WAh9\u0006M\u0006v1\u0019\u0019Eg/\u0006PFi|\u0007\\Y{5\u0007\\L.5\u001bMM`(U_Ab(\u0010K\u00084|\u0016W\u0006d,\u0000J@ =\u001b]Za5\u0011\u0017A`(\u0010W\\ \u000e0ig\\\u0008"

    const/16 v0, 0x75

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_75
    aput-object v6, v8, v7

    const/16 v7, 0x77

    const-string v6, "i`8\u0007VAj\u0011\u0014WAh9\u0006M\u0006v1\u0019\u0019Eg/\u0006PFi|\u0007\\Y{5\u0007\\L.5\u001bMM`(U_Ab(\u0010K\u0008h3\u0007\u0019x{/\u001dkMm9\u001cOM|fUZF 6\u0005L[fr\u0014WL|3\u001c]\u0006g2\u0001\\Fzr;v|G\u001a<ziZ\u0015:ww\\\u00196|aX\u00191fx\\\u0013-`"

    const/16 v0, 0x76

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_76
    aput-object v6, v8, v7

    const/16 v7, 0x78

    const-string v6, "\u007fk|\u0007\\Ka1\u0018\\Fj|\u000cV].=\u0011]\u0008z4\u0010\u0019Xk.\u0018P[}5\u001aW\u0008#|"

    const/16 v0, 0x77

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_77
    aput-object v6, v8, v7

    const/16 v7, 0x79

    const-string v6, "i`8\u0007VAj\u0011\u0014WAh9\u0006M\u0006v1\u0019\u0019Eg/\u0006PFi|\u0007\\Y{5\u0007\\L.5\u001bMM`(U_Ab(\u0010K\u0008h3\u0007\u0019x{/\u001djM|*\u001cZM4|\u0016W\u0006d,\u0000J@ =\u001b]Za5\u0011\u0017A`(\u0010W\\ \u000e0~a]\u00080k"

    const/16 v0, 0x78

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_78
    aput-object v6, v8, v7

    const/16 v7, 0x7a

    const-string v6, "qa)UJ@a)\u0019]\u0008c=\u001e\\\u0008c=\u001cW\u0008o?\u0001P^g(\u000c\u0019Mv(\u0010WL}|<W[z.\u0000TM`(\u0010]im(\u001cOAz%U\u0011b^)\u0006Q\u0001\"|\u001aM@k.\u0002P[k|\u000cV].+\u001cUD.2\u001aM\u0008}9\u0010\u0019]}9\u0007\u0019Kb5\u0016R\u0008o2\u0011\u0019]}9\u0007\u0019Im(\u001cOM.(\u001cTM./\u0001XZz|\u001aW\u0008|9\u0005VZz|\u001cW\u0008^3\u0007MIbrU"

    const/16 v0, 0x79

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_79
    aput-object v6, v8, v7

    const/16 v7, 0x7b

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL 5\u001bMM`([km^\u0013\'m"

    const/16 v0, 0x7a

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_7a
    aput-object v6, v8, v7

    const/16 v7, 0x7c

    const-string v6, "\u0004.3\u0001QM|+\u001cJM.%\u001aL\u0008m=\u001b\u0019Fa(UUGm=\u0001\\\u0008z4\u0010\u0019Lk*\u001cZM}r"

    const/16 v0, 0x7b

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_7b
    aput-object v6, v8, v7

    const/16 v7, 0x7d

    const-string v6, "K`r\u001fI]}4[XFj.\u001aPL 5\u001bMM`([kmI\u0015&mm\\"

    const/16 v0, 0x7c

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_7c
    aput-object v6, v8, v7

    const/16 v7, 0x7e

    const-string v6, "x{/\u001dkMm9\u001cOM||\u0006QG{0\u0011\u0019Fa(UQIx9UPFz9\u001bM\u0008h5\u0019MM||X\u0014\u0008o2\u0011KGg8[PFz9\u001bM\u0006o?\u0001PG`r7vgZ\u00036ve^\u00100mmJpUiDk=\u0006\\\u0008|9\u0018V^k|\u0001QM.5\u001bMM`(U_Ab(\u0010K\u0008g2UxFj.\u001aPLC=\u001bPNk/\u0001\u0017Pc0"

    const/16 v0, 0x7d

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_7d
    aput-object v6, v8, v7

    const/16 v7, 0x7f

    const-string v6, "\u0006~9\u0007TA}/\u001cVF \u0016%l{F\u00038|{]\u001d2|"

    const/16 v0, 0x7e

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_7e
    aput-object v6, v8, v7

    const/16 v7, 0x80

    const-string v6, "|f9UIM|1\u001cJ[g3\u001b\u0019[f3\u0000UL.>\u0010\u0019Lk:\u001cWMj|X\u0019"

    const/16 v0, 0x7f

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_7f
    aput-object v6, v8, v7

    const/16 v7, 0x81

    const-string v6, "k@a4WL|3\u001c]\u0008J9\u0017LO\"\u0013HxFj.\u001aPL\"\u001fHl{"

    const/16 v0, 0x80

    move-object v8, v9

    goto/16 :goto_0

    :pswitch_80
    aput-object v6, v8, v7

    sput-object v9, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    sput-object v6, Lcn/jpush/android/util/a;->b:Ljava/util/List;

    const-string v0, "\u001b;dC\u000e\u001b>mF\u000e\u0011;dL\u000c"

    move-object v7, v6

    move-object v6, v0

    move v0, v1

    :goto_1
    invoke-static {v6}, Lcn/jpush/android/util/a;->z(Ljava/lang/String;)[C

    move-result-object v6

    invoke-static {v6}, Lcn/jpush/android/util/a;->z([C)Ljava/lang/String;

    move-result-object v6

    packed-switch v0, :pswitch_data_1

    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    sget-object v6, Lcn/jpush/android/util/a;->b:Ljava/util/List;

    const-string v0, "\u0018>hL\u0000\u0011>mE\u000f\u001c>lE\t"

    move-object v7, v6

    move-object v6, v0

    move v0, v1

    :goto_2
    invoke-static {v6}, Lcn/jpush/android/util/a;->z(Ljava/lang/String;)[C

    move-result-object v6

    invoke-static {v6}, Lcn/jpush/android/util/a;->z([C)Ljava/lang/String;

    move-result-object v6

    packed-switch v0, :pswitch_data_2

    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    sget-object v6, Lcn/jpush/android/util/a;->b:Ljava/util/List;

    const-string v0, "\u0018>lE\t\u0018>lE\t\u0018>lE"

    move-object v7, v6

    move-object v6, v0

    move v0, v2

    goto :goto_2

    :pswitch_81
    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v0, Ljavax/security/auth/x500/X500Principal;

    sget-object v6, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v7, 0x81

    aget-object v6, v6, v7

    invoke-direct {v0, v6}, Ljavax/security/auth/x500/X500Principal;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcn/jpush/android/util/a;->c:Ljavax/security/auth/x500/X500Principal;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v6

    invoke-virtual {v6}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v0, "\u0007j=\u0001X\u0007"

    move-object v7, v6

    move-object v6, v0

    move v0, v1

    :goto_3
    invoke-static {v6}, Lcn/jpush/android/util/a;->z(Ljava/lang/String;)[C

    move-result-object v6

    invoke-static {v6}, Lcn/jpush/android/util/a;->z([C)Ljava/lang/String;

    move-result-object v6

    packed-switch v0, :pswitch_data_3

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/util/a;->d:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v6

    invoke-virtual {v6}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v0, "\u0007j=\u0001X\u0007 ,\u0000J@Q)\u0011PL"

    move-object v7, v6

    move-object v6, v0

    move v0, v2

    goto :goto_3

    :pswitch_82
    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    sget-object v6, Lcn/jpush/android/util/a;->b:Ljava/util/List;

    const-string v0, "\u0018>lE\t\u0018>lE\t\u0018>lE\t"

    move-object v7, v6

    move-object v6, v0

    move v0, v3

    goto :goto_2

    :pswitch_83
    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/util/a;->e:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v6

    invoke-virtual {v6}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v0, "\u0007j=\u0001X\u0007 ,\u0000J@Q8\u0010OAm9\u001c]"

    move-object v7, v6

    move-object v6, v0

    move v0, v3

    goto :goto_3

    :pswitch_84
    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/util/a;->f:Ljava/lang/String;

    sput v3, Lcn/jpush/android/util/a;->a:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcn/jpush/android/util/a;->g:Ljava/util/ArrayList;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcn/jpush/android/util/a;->h:Ljava/util/ArrayList;

    sget-object v6, Lcn/jpush/android/util/a;->g:Ljava/util/ArrayList;

    const-string v0, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[pfZ\u0019\'wmZ"

    move-object v7, v6

    move-object v6, v0

    move v0, v2

    goto/16 :goto_1

    :pswitch_85
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v6, Lcn/jpush/android/util/a;->g:Ljava/util/ArrayList;

    const-string v0, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[niE\u0019*ugM\u0017"

    move-object v7, v6

    move-object v6, v0

    move v0, v3

    goto/16 :goto_1

    :pswitch_86
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v0, Lcn/jpush/android/util/a;->g:Ljava/util/ArrayList;

    sget-object v6, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v6, v6, v5

    invoke-virtual {v0, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v6, Lcn/jpush/android/util/a;->g:Ljava/util/ArrayList;

    const-string v0, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[xkM\u0019&jw@\u0019!ng\\\u0017*j|O\u00080"

    move-object v7, v6

    move-object v6, v0

    move v0, v4

    goto/16 :goto_1

    :pswitch_87
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v7, Lcn/jpush/android/util/a;->h:Ljava/util/ArrayList;

    const-string v6, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[oaL\u000e4mm"

    const/4 v0, 0x3

    goto/16 :goto_1

    :pswitch_88
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v7, Lcn/jpush/android/util/a;->h:Ljava/util/ArrayList;

    const-string v6, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[z`O\u00122|wY\u00153pw]\u00084mm"

    const/4 v0, 0x4

    goto/16 :goto_1

    :pswitch_89
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    sput-object v7, Lcn/jpush/android/util/a;->i:Ljava/util/ArrayList;

    const-string v6, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[xkM\u0019&jwH\u0015;|wB\u00136x|G\u0013;"

    const/4 v0, 0x5

    goto/16 :goto_1

    :pswitch_8a
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v7, Lcn/jpush/android/util/a;->i:Ljava/util/ArrayList;

    const-string v6, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[xkM\u0019&jwM\u00134k{K\u00039vkO\u0008<vf"

    const/4 v0, 0x6

    goto/16 :goto_1

    :pswitch_8b
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v6, Lcn/jpush/android/util/a;->i:Ljava/util/ArrayList;

    const-string v0, "I`8\u0007VAjr\u0005\\Zc5\u0006JAa2[xkM\u0019&jwB\u00136x|G\u0013;fmV\u0008\'xwM\u00138ti@\u0018&"

    move-object v7, v6

    move-object v6, v0

    move v0, v5

    goto/16 :goto_1

    :pswitch_8c
    invoke-virtual {v7, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v0, Lcn/jpush/android/util/a;->i:Ljava/util/ArrayList;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x47

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_17
        :pswitch_18
        :pswitch_19
        :pswitch_1a
        :pswitch_1b
        :pswitch_1c
        :pswitch_1d
        :pswitch_1e
        :pswitch_1f
        :pswitch_20
        :pswitch_21
        :pswitch_22
        :pswitch_23
        :pswitch_24
        :pswitch_25
        :pswitch_26
        :pswitch_27
        :pswitch_28
        :pswitch_29
        :pswitch_2a
        :pswitch_2b
        :pswitch_2c
        :pswitch_2d
        :pswitch_2e
        :pswitch_2f
        :pswitch_30
        :pswitch_31
        :pswitch_32
        :pswitch_33
        :pswitch_34
        :pswitch_35
        :pswitch_36
        :pswitch_37
        :pswitch_38
        :pswitch_39
        :pswitch_3a
        :pswitch_3b
        :pswitch_3c
        :pswitch_3d
        :pswitch_3e
        :pswitch_3f
        :pswitch_40
        :pswitch_41
        :pswitch_42
        :pswitch_43
        :pswitch_44
        :pswitch_45
        :pswitch_46
        :pswitch_47
        :pswitch_48
        :pswitch_49
        :pswitch_4a
        :pswitch_4b
        :pswitch_4c
        :pswitch_4d
        :pswitch_4e
        :pswitch_4f
        :pswitch_50
        :pswitch_51
        :pswitch_52
        :pswitch_53
        :pswitch_54
        :pswitch_55
        :pswitch_56
        :pswitch_57
        :pswitch_58
        :pswitch_59
        :pswitch_5a
        :pswitch_5b
        :pswitch_5c
        :pswitch_5d
        :pswitch_5e
        :pswitch_5f
        :pswitch_60
        :pswitch_61
        :pswitch_62
        :pswitch_63
        :pswitch_64
        :pswitch_65
        :pswitch_66
        :pswitch_67
        :pswitch_68
        :pswitch_69
        :pswitch_6a
        :pswitch_6b
        :pswitch_6c
        :pswitch_6d
        :pswitch_6e
        :pswitch_6f
        :pswitch_70
        :pswitch_71
        :pswitch_72
        :pswitch_73
        :pswitch_74
        :pswitch_75
        :pswitch_76
        :pswitch_77
        :pswitch_78
        :pswitch_79
        :pswitch_7a
        :pswitch_7b
        :pswitch_7c
        :pswitch_7d
        :pswitch_7e
        :pswitch_7f
        :pswitch_80
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_85
        :pswitch_86
        :pswitch_87
        :pswitch_88
        :pswitch_89
        :pswitch_8a
        :pswitch_8b
        :pswitch_8c
    .end packed-switch

    :pswitch_data_2
    .packed-switch 0x0
        :pswitch_82
        :pswitch_81
    .end packed-switch

    :pswitch_data_3
    .packed-switch 0x0
        :pswitch_83
        :pswitch_84
    .end packed-switch
.end method

.method private static A(Landroid/content/Context;)Ljava/lang/String;
    .locals 5

    const/4 v1, 0x0

    invoke-static {}, Lcn/jpush/android/util/a;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v0, v0, v2

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Ljava/io/File;

    sget-object v2, Lcn/jpush/android/util/a;->f:Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_2

    :try_start_0
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-static {v2}, Lcn/jpush/android/util/m;->a(Ljava/io/InputStream;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_2

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x9

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v0, v1

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_0
.end method

.method private static B(Landroid/content/Context;)Ljava/lang/String;
    .locals 2

    invoke-static {p0}, Lcn/jpush/android/util/a;->k(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-static {v0}, Lcn/jpush/android/util/a;->d(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x9

    if-lt v0, v1, :cond_4

    sget-object v0, Landroid/os/Build;->SERIAL:Ljava/lang/String;

    :goto_1
    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    invoke-static {v0}, Lcn/jpush/android/util/a;->d(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    :cond_2
    const-string v0, " "

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->i(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    invoke-static {v0}, Lcn/jpush/android/util/a;->d(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    :cond_3
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_4
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private static C(Landroid/content/Context;)Z
    .locals 4

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x33

    aget-object v1, v1, v2

    invoke-static {v0, v1}, Landroid/provider/Settings$System;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v0, ""

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->i(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :cond_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x33

    aget-object v2, v2, v3

    invoke-static {v1, v2, v0}, Landroid/provider/Settings$System;->putString(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static D(Landroid/content/Context;)Z
    .locals 4

    const/4 v0, 0x0

    :try_start_0
    new-instance v1, Landroid/content/Intent;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v3, 0x4

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->resolveActivity(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;

    move-result-object v1

    iget-object v1, v1, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v1, :cond_0

    iget-object v1, v1, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const-class v2, Lcn/jpush/android/api/InstrumentedActivity;

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-nez v2, :cond_2

    const-class v2, Lcn/jpush/android/api/InstrumentedListActivity;

    invoke-virtual {v2, v1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private static E(Landroid/content/Context;)V
    .locals 5

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    sget-object v0, Lcn/jpush/android/util/a;->j:Lcn/jpush/android/service/PushReceiver;

    if-nez v0, :cond_0

    new-instance v0, Lcn/jpush/android/service/PushReceiver;

    invoke-direct {v0}, Lcn/jpush/android/service/PushReceiver;-><init>()V

    sput-object v0, Lcn/jpush/android/util/a;->j:Lcn/jpush/android/service/PushReceiver;

    :cond_0
    sget-object v0, Lcn/jpush/android/util/a;->j:Lcn/jpush/android/service/PushReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x44

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    sget-object v0, Lcn/jpush/android/util/a;->j:Lcn/jpush/android/service/PushReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x41

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    :try_start_0
    new-instance v0, Landroid/content/IntentFilter;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x45

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x43

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    new-instance v1, Landroid/content/IntentFilter;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x42

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x43

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    new-instance v2, Landroid/content/IntentFilter;

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x40

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    const/16 v3, 0x3e8

    invoke-virtual {v2, v3}, Landroid/content/IntentFilter;->setPriority(I)V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/IntentFilter;->addCategory(Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/util/a;->j:Lcn/jpush/android/service/PushReceiver;

    invoke-virtual {p0, v3, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    sget-object v0, Lcn/jpush/android/util/a;->j:Lcn/jpush/android/service/PushReceiver;

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    sget-object v0, Lcn/jpush/android/util/a;->j:Lcn/jpush/android/service/PushReceiver;

    invoke-virtual {p0, v0, v2}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public static a(B)I
    .locals 1

    and-int/lit16 v0, p0, 0xff

    return v0
.end method

.method public static a(Landroid/content/Context;F)I
    .locals 1

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v0, p1

    float-to-int v0, v0

    return v0
.end method

.method public static a(Landroid/content/Context;Lcn/jpush/android/data/d;Z)Landroid/content/Intent;
    .locals 3

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x4a

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x49

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x48

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    return-object v0
.end method

.method public static a(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    if-nez v0, :cond_0

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x63

    aget-object v0, v0, v1

    :goto_0
    return-object v0

    :cond_0
    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels:I

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "*"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 9

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/16 v8, 0x64

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, ","

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x11

    aget-object v0, v0, v5

    sget-object v5, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v6, 0xe

    aget-object v5, v5, v6

    invoke-static {p0, v0, v5}, Lcn/jpush/android/service/q;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    sget-object v6, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/a;->e:Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, " "

    :goto_0
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v7, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v7, v7, v8

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v4, v4, v8

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v4, v4, v8

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v4, v4, v8

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v3, v3, v8

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v3, v3, v8

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    iget-object v0, v0, Landroid/content/pm/ApplicationInfo;->sourceDir:Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    move v0, v2

    :goto_1
    if-eqz v0, :cond_4

    move v0, v1

    :goto_2
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v1, v1, v8

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p0}, Lcn/jpush/android/util/a;->a(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    sget-object v0, Lcn/jpush/android/a;->e:Ljava/lang/String;

    goto :goto_0

    :cond_1
    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v6, 0x65

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x66

    aget-object v4, v4, v5

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    move v0, v1

    goto :goto_1

    :cond_2
    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x67

    aget-object v4, v4, v5

    invoke-virtual {v0, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    move v0, v2

    goto :goto_1

    :cond_3
    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    move v0, v2

    goto :goto_1

    :cond_4
    move v0, v2

    goto :goto_2
.end method

.method public static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 6

    const/4 v0, 0x0

    :try_start_0
    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x1b

    aget-object v1, v1, v2

    invoke-static {v1}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v2

    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v3

    array-length v1, v3

    new-array v4, v1, [B

    move v1, v0

    :goto_0
    array-length v5, v3

    if-ge v1, v5, :cond_0

    aget-char v5, v3, v1

    int-to-byte v5, v5

    aput-byte v5, v4, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    invoke-virtual {v2, v4}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    :goto_1
    array-length v3, v1

    if-ge v0, v3, :cond_2

    aget-byte v3, v1, v0

    and-int/lit16 v3, v3, 0xff

    const/16 v4, 0x10

    if-ge v3, v4, :cond_1

    const-string v4, "0"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_1
    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_2
    return-object v0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const-string v0, ""

    goto :goto_2
.end method

.method public static a([B)Ljava/lang/String;
    .locals 5

    :try_start_0
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x1b

    aget-object v0, v0, v1

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const/4 v0, 0x0

    :goto_0
    array-length v3, v1

    if-ge v0, v3, :cond_1

    aget-byte v3, v1, v0

    and-int/lit16 v3, v3, 0xff

    const/16 v4, 0x10

    if-ge v3, v4, :cond_0

    const-string v4, "0"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_0
    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_1
    return-object v0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const-string v0, ""

    goto :goto_1
.end method

.method public static a(Ljava/lang/String;Lorg/json/JSONArray;)Lorg/json/JSONObject;
    .locals 9

    const/4 v1, 0x0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    move-object v0, v1

    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    :try_start_0
    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x3a

    aget-object v2, v2, v3

    invoke-virtual {v0, v2, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x2e

    aget-object v2, v2, v3

    invoke-virtual {v0, v2, p0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x3b

    aget-object v2, v2, v3

    sget-wide v3, Lcn/jpush/android/service/PushService;->m:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/16 v7, 0x3e8

    div-long/2addr v5, v7

    sget-wide v7, Lcn/jpush/android/service/PushService;->n:J

    sub-long/2addr v5, v7

    invoke-static {v5, v6}, Ljava/lang/Math;->abs(J)J

    move-result-wide v5

    add-long/2addr v3, v5

    invoke-virtual {v0, v2, v3, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    move-object v0, v1

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Lcn/jpush/android/data/d;)V
    .locals 5

    :try_start_0
    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x4c

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x4b

    aget-object v1, v1, v2

    iget-object v2, p1, Lcn/jpush/android/data/d;->n:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x4d

    aget-object v1, v1, v2

    iget-object v2, p1, Lcn/jpush/android/data/d;->i:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x50

    aget-object v1, v1, v2

    iget-object v2, p1, Lcn/jpush/android/data/d;->j:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x52

    aget-object v1, v1, v2

    iget-object v2, p1, Lcn/jpush/android/data/d;->k:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x25

    aget-object v1, v1, v2

    iget-object v2, p1, Lcn/jpush/android/data/d;->l:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x4f

    aget-object v1, v1, v2

    iget-object v2, p1, Lcn/jpush/android/data/d;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p1}, Lcn/jpush/android/data/d;->f()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x51

    aget-object v1, v1, v2

    iget-object v2, p1, Lcn/jpush/android/data/d;->U:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    :cond_0
    iget-object v1, p1, Lcn/jpush/android/data/d;->m:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x28

    aget-object v1, v1, v2

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p1, Lcn/jpush/android/data/d;->m:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x4e

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x28

    aget-object v1, v1, v2

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p1, Lcn/jpush/android/data/d;->m:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    iget-object v0, p1, Lcn/jpush/android/data/d;->c:Ljava/lang/String;

    const/16 v1, 0x3fa

    invoke-static {v0, v1, p0}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 5

    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x5e

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :goto_0
    return-void

    :cond_0
    new-instance v1, Landroid/content/Intent;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x1c

    aget-object v2, v2, v3

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    const/high16 v0, 0x14000000

    invoke-virtual {v1, v0}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    invoke-static {p0, p3}, Landroid/content/Intent$ShortcutIconResource;->fromContext(Landroid/content/Context;I)Landroid/content/Intent$ShortcutIconResource;

    move-result-object v0

    new-instance v2, Landroid/content/Intent;

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x5d

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x61

    aget-object v3, v3, v4

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x60

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x5c

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x5f

    aget-object v1, v1, v3

    invoke-virtual {v2, v1, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    invoke-virtual {p0, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static a()Z
    .locals 3

    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x55

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :cond_0
    return v0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 4

    const/4 v0, 0x0

    if-nez p0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x19

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x18

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    :goto_0
    return v0

    :cond_1
    invoke-static {p0, p1}, Lcn/jpush/android/util/a;->n(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    if-nez v1, :cond_3

    :try_start_0
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->c()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto :goto_0

    :cond_2
    :try_start_1
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    invoke-virtual {v1, p1, p2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    :cond_3
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Z)Z
    .locals 4

    const/4 v0, 0x0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {v1, v2, v0}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static b([B)I
    .locals 2

    if-eqz p0, :cond_0

    array-length v0, p0

    const/16 v1, 0x14

    if-ge v0, v1, :cond_1

    :cond_0
    const/4 v0, -0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x3

    aget-byte v0, p0, v0

    and-int/lit16 v0, v0, 0xff

    goto :goto_0
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 9

    const/16 v4, 0xe

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x11

    aget-object v0, v0, v3

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v3, v3, v4

    invoke-static {p0, v0, v3}, Lcn/jpush/android/service/q;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/a;->e:Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, " "

    :goto_0
    invoke-static {p0}, Lcn/jpush/android/util/a;->d(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    :try_start_0
    sget-object v7, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v8, 0xc

    aget-object v7, v7, v8

    invoke-virtual {v6, v7, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v7, 0xd

    aget-object v1, v1, v7

    invoke-virtual {v6, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0xe

    aget-object v1, v1, v2

    invoke-virtual {v6, v1, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0xb

    aget-object v1, v1, v2

    invoke-virtual {v6, v1, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0xa

    aget-object v1, v1, v2

    invoke-virtual {v6, v1, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0xf

    aget-object v0, v0, v1

    invoke-virtual {v6, v0, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x10

    aget-object v0, v0, v1

    invoke-virtual {v6, v0, p1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    invoke-virtual {v6}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    sget-object v0, Lcn/jpush/android/a;->e:Ljava/lang/String;

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public static b(Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    :try_start_0
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x1b

    aget-object v0, v0, v1

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x54

    aget-object v1, v1, v2

    invoke-virtual {p0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/security/MessageDigest;->digest([B)[B

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const/4 v0, 0x0

    :goto_0
    array-length v3, v1

    if-ge v0, v3, :cond_1

    aget-byte v3, v1, v0

    and-int/lit16 v3, v3, 0xff

    const/16 v4, 0x10

    if-ge v3, v4, :cond_0

    const-string v4, "0"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    :cond_0
    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_1
    return-object v0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const-string v0, ""

    goto :goto_1
.end method

.method public static b()V
    .locals 4

    invoke-static {}, Lcn/jpush/android/service/r;->a()Lcn/jpush/android/service/r;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/service/r;->b()Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v1

    if-eqz v1, :cond_0

    :try_start_0
    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->release()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :cond_1
    return-void

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x1a

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto :goto_0
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5

    :try_start_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x25

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x27

    aget-object v2, v2, v3

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x26

    aget-object v3, v3, v4

    invoke-static {v2, v3}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x28

    aget-object v2, v2, v3

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto :goto_0
.end method

.method public static b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 8

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcn/jpush/android/service/PushReceiver;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x30

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x2c

    aget-object v1, v1, v2

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x32

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x2e

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    const/4 v1, 0x0

    const/high16 v2, 0x8000000

    invoke-static {p0, v1, v0, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x2f

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    const/4 v1, -0x1

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x100

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v1, v3, Landroid/content/pm/ApplicationInfo;->icon:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    if-gez v1, :cond_0

    const v1, 0x1080052

    :cond_0
    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x2d

    aget-object v3, v3, v4

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x31

    aget-object v4, v4, v5

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    new-instance v7, Landroid/app/Notification;

    invoke-direct {v7, v1, p1, v5, v6}, Landroid/app/Notification;-><init>(ILjava/lang/CharSequence;J)V

    const/16 v1, 0x22

    iput v1, v7, Landroid/app/Notification;->flags:I

    invoke-virtual {v7, p0, v3, v4, v2}, Landroid/app/Notification;->setLatestEventInfo(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v1

    invoke-virtual {v0, v1, v7}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    return-void

    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method public static b(Landroid/content/Context;)Z
    .locals 2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static b(Landroid/content/Context;Ljava/lang/String;Z)Z
    .locals 3

    const/4 v0, 0x0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v0}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static c([B)I
    .locals 3

    const/4 v0, 0x0

    if-eqz p0, :cond_0

    array-length v1, p0

    const/4 v2, 0x6

    if-ge v1, v2, :cond_1

    :cond_0
    return v0

    :cond_1
    move v1, v0

    :goto_0
    const/4 v2, 0x2

    if-ge v1, v2, :cond_0

    shl-int/lit8 v0, v0, 0x8

    aget-byte v2, p0, v1

    and-int/lit16 v2, v2, 0xff

    add-int/2addr v2, v0

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    move v0, v2

    goto :goto_0
.end method

.method public static c()Ljava/lang/String;
    .locals 6

    const/16 v3, 0x57

    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    new-instance v1, Ljava/io/File;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_1

    :try_start_0
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v2, Ljava/io/FileReader;

    new-instance v3, Ljava/io/File;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x57

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {v2, v3}, Ljava/io/FileReader;-><init>(Ljava/io/File;)V

    invoke-direct {v1, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    :cond_0
    :goto_0
    invoke-virtual {v1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x58

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    const-string v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    if-ltz v3, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-ge v3, v4, :cond_0

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    :cond_1
    :goto_1
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_2
    :try_start_1
    invoke-virtual {v1}, Ljava/io/BufferedReader;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method public static c(Landroid/content/Context;)S
    .locals 1

    invoke-static {p0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;)S

    move-result v0

    return v0
.end method

.method public static c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 8

    invoke-static {p0}, Lcn/jpush/android/util/a;->i(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcn/jpush/android/service/PushReceiver;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x30

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x2c

    aget-object v1, v1, v2

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x59

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const/4 v1, 0x0

    const/high16 v2, 0x8000000

    invoke-static {p0, v1, v0, v2}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x2f

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    const/4 v1, -0x1

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x100

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget v1, v3, Landroid/content/pm/ApplicationInfo;->icon:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_1
    if-gez v1, :cond_1

    const v1, 0x1080052

    :cond_1
    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x5a

    aget-object v3, v3, v4

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x5b

    aget-object v4, v4, v5

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    new-instance v7, Landroid/app/Notification;

    invoke-direct {v7, v1, p1, v5, v6}, Landroid/app/Notification;-><init>(ILjava/lang/CharSequence;J)V

    const/16 v1, 0x22

    iput v1, v7, Landroid/app/Notification;->flags:I

    invoke-virtual {v7, p0, v3, v4, v2}, Landroid/app/Notification;->setLatestEventInfo(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v1

    invoke-virtual {v0, v1, v7}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    goto :goto_0

    :catch_0
    move-exception v3

    goto :goto_1
.end method

.method public static c(Ljava/lang/String;)V
    .locals 1

    sget-object v0, Lcn/jpush/android/util/a;->b:Ljava/util/List;

    invoke-interface {v0, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public static c(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3

    if-eqz p0, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x8

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static d()Ljava/lang/String;
    .locals 4

    :try_start_0
    invoke-static {}, Ljava/net/NetworkInterface;->getNetworkInterfaces()Ljava/util/Enumeration;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/net/NetworkInterface;

    invoke-virtual {v0}, Ljava/net/NetworkInterface;->getInetAddresses()Ljava/util/Enumeration;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/net/InetAddress;

    invoke-virtual {v0}, Ljava/net/InetAddress;->isLoopbackAddress()Z

    move-result v3

    if-nez v3, :cond_1

    instance-of v3, v0, Ljava/net/Inet4Address;

    if-eqz v3, :cond_1

    invoke-virtual {v0}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    :cond_2
    const-string v0, ""

    goto :goto_0
.end method

.method public static d(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    const/16 v2, 0x53

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    if-nez v1, :cond_1

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v2

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getTypeName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getSubtypeName()Ljava/lang/String;

    move-result-object v1

    if-nez v0, :cond_2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v2

    goto :goto_0

    :cond_2
    if-eqz v1, :cond_0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static d(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    new-instance v1, Landroid/content/ComponentName;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v2, 0x80

    :try_start_0
    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getReceiverInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static d(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 4

    const/4 v1, 0x0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2, p2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {v0, v2, v1}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    iget-object v0, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v0, :cond_0

    iget-object v0, v0, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method private static d(Ljava/lang/String;)Z
    .locals 3

    const/4 v2, 0x0

    invoke-static {p0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return v2

    :cond_1
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0xa

    if-lt v0, v1, :cond_0

    move v1, v2

    :goto_1
    sget-object v0, Lcn/jpush/android/util/a;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    sget-object v0, Lcn/jpush/android/util/a;->b:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p0, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcn/jpush/android/util/a;->b:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    :cond_2
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public static e(Landroid/content/Context;)Ljava/lang/String;
    .locals 2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getTypeName()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static e(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x1c

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x1d

    aget-object v2, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method public static f(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->h(Landroid/content/Context;Ljava/lang/String;)V

    return-void
.end method

.method public static f(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3

    const/4 v0, 0x0

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static g(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x47

    aget-object v0, v0, v1

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-object p1

    :cond_1
    :try_start_0
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x20

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/wifi/WifiInfo;->getMacAddress()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-nez v1, :cond_0

    move-object p1, v0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    goto :goto_0
.end method

.method public static g(Landroid/content/Context;)Z
    .locals 2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x38

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    invoke-virtual {v0}, Landroid/os/PowerManager;->isScreenOn()Z

    move-result v0

    return v0
.end method

.method public static h(Landroid/content/Context;)I
    .locals 4

    const/4 v0, -0x1

    new-instance v1, Landroid/content/IntentFilter;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x2a

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    const/4 v2, 0x0

    invoke-virtual {p0, v2, v1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    move-result-object v2

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x2b

    aget-object v1, v1, v3

    invoke-virtual {v2, v1, v0}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    const/4 v3, 0x2

    if-eq v1, v3, :cond_0

    const/4 v3, 0x5

    if-ne v1, v3, :cond_1

    :cond_0
    const/4 v1, 0x1

    :goto_0
    if-nez v1, :cond_2

    :goto_1
    return v0

    :cond_1
    const/4 v1, 0x0

    goto :goto_0

    :cond_2
    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x29

    aget-object v1, v1, v3

    invoke-virtual {v2, v1, v0}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    goto :goto_1
.end method

.method public static h(Landroid/content/Context;Ljava/lang/String;)V
    .locals 6

    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v2, 0x4

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    invoke-static {p1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x25

    aget-object v2, v2, v3

    invoke-virtual {v0, v2, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    :cond_0
    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    invoke-virtual {v0, v2}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Landroid/content/pm/PackageManager;->resolveActivity(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x46

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, v2, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v4, v4, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    iget-object v2, v2, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method public static i(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x13

    aget-object v0, v0, v1

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x12

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object p1

    :cond_0
    return-object p1
.end method

.method public static i(Landroid/content/Context;)Z
    .locals 6

    const/4 v1, 0x0

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x40

    invoke-virtual {v0, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget-object v3, v0, Landroid/content/pm/PackageInfo;->signatures:[Landroid/content/pm/Signature;

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x3e

    aget-object v0, v0, v2

    invoke-static {v0}, Ljava/security/cert/CertificateFactory;->getInstance(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;

    move-result-object v4

    move v2, v1

    :goto_0
    array-length v0, v3

    if-ge v2, v0, :cond_1

    new-instance v0, Ljava/io/ByteArrayInputStream;

    aget-object v5, v3, v2

    invoke-virtual {v5}, Landroid/content/pm/Signature;->toByteArray()[B

    move-result-object v5

    invoke-direct {v0, v5}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-virtual {v4, v0}, Ljava/security/cert/CertificateFactory;->generateCertificate(Ljava/io/InputStream;)Ljava/security/cert/Certificate;

    move-result-object v0

    check-cast v0, Ljava/security/cert/X509Certificate;

    invoke-virtual {v0}, Ljava/security/cert/X509Certificate;->getSubjectX500Principal()Ljavax/security/auth/x500/X500Principal;

    move-result-object v0

    sget-object v5, Lcn/jpush/android/util/a;->c:Ljavax/security/auth/x500/X500Principal;

    invoke-virtual {v0, v5}, Ljavax/security/auth/x500/X500Principal;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    if-nez v0, :cond_0

    add-int/lit8 v1, v2, 0x1

    move v2, v1

    move v1, v0

    goto :goto_0

    :catch_0
    move-exception v0

    move v0, v1

    :cond_0
    :goto_1
    return v0

    :catch_1
    move-exception v0

    move v0, v1

    goto :goto_1

    :cond_1
    move v0, v1

    goto :goto_1
.end method

.method public static j(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    const/16 v2, 0x68

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v2

    const-string v1, ""

    invoke-static {p0, v0, v1}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lcn/jpush/android/util/a;->d(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {p0}, Lcn/jpush/android/util/a;->y(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v1, v1, v2

    invoke-static {p0, v1, v0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static j(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2

    invoke-static {p1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p0, p1}, Lcn/jpush/android/util/a;->q(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    invoke-static {p0, p1}, Lcn/jpush/android/util/a;->o(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x24

    aget-object v0, v0, v1

    invoke-static {p0, v0, p1}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public static k(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x56

    aget-object v1, v1, v2

    invoke-static {v0, v1}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static k(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3

    if-eqz p0, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x8

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const/16 v1, 0x80

    :try_start_0
    invoke-virtual {v0, p1, v1}, Landroid/content/pm/PackageManager;->getPermissionInfo(Ljava/lang/String;I)Landroid/content/pm/PermissionInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static l(Landroid/content/Context;)Ljava/lang/String;
    .locals 7

    const/4 v2, 0x1

    const/4 v1, 0x0

    const/16 v6, 0x24

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v6

    const/4 v3, 0x0

    invoke-static {p0, v0, v3}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    sget-object v1, Lcn/jpush/android/util/b;->d:Lcn/jpush/android/util/b;

    invoke-virtual {v1}, Lcn/jpush/android/util/b;->ordinal()I

    move-result v1

    sput v1, Lcn/jpush/android/util/a;->a:I

    :goto_0
    return-object v0

    :cond_0
    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->p(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    sget-object v1, Lcn/jpush/android/util/b;->b:Lcn/jpush/android/util/b;

    invoke-virtual {v1}, Lcn/jpush/android/util/b;->ordinal()I

    move-result v1

    sput v1, Lcn/jpush/android/util/a;->a:I

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->o(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v1, v1, v6

    invoke-static {p0, v1, v0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    invoke-static {p0}, Lcn/jpush/android/util/a;->A(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    sget-object v1, Lcn/jpush/android/util/b;->c:Lcn/jpush/android/util/b;

    invoke-virtual {v1}, Lcn/jpush/android/util/b;->ordinal()I

    move-result v1

    sput v1, Lcn/jpush/android/util/a;->a:I

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->q(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v1, v1, v6

    invoke-static {p0, v1, v0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x23

    aget-object v3, v3, v4

    invoke-static {p0, v3}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v5, 0x7

    aget-object v3, v3, v5

    invoke-static {p0, v3}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-static {}, Lcn/jpush/android/util/a;->a()Z

    move-result v3

    if-eqz v3, :cond_3

    move v3, v2

    :goto_1
    if-nez v4, :cond_4

    if-nez v3, :cond_4

    :goto_2
    if-nez v1, :cond_6

    sget-object v0, Lcn/jpush/android/util/b;->e:Lcn/jpush/android/util/b;

    invoke-virtual {v0}, Lcn/jpush/android/util/b;->ordinal()I

    move-result v0

    sput v0, Lcn/jpush/android/util/a;->a:I

    invoke-static {p0}, Lcn/jpush/android/util/a;->B(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_3
    move v3, v1

    goto :goto_1

    :cond_4
    if-nez v3, :cond_5

    if-eqz v4, :cond_5

    invoke-static {p0}, Lcn/jpush/android/util/a;->C(Landroid/content/Context;)Z

    move-result v1

    goto :goto_2

    :cond_5
    move v1, v2

    goto :goto_2

    :cond_6
    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->i(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0}, Lcn/jpush/android/util/a;->k(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    const-string v0, ""

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->g(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/util/a;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_9

    :goto_3
    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->q(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->o(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-static {v1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_8

    :cond_7
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x3f

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v1, v1, v6

    invoke-static {p0, v1, v0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/util/b;->a:Lcn/jpush/android/util/b;

    invoke-virtual {v1}, Lcn/jpush/android/util/b;->ordinal()I

    move-result v1

    sput v1, Lcn/jpush/android/util/a;->a:I

    goto/16 :goto_0

    :cond_8
    sget-object v0, Lcn/jpush/android/util/b;->e:Lcn/jpush/android/util/b;

    invoke-virtual {v0}, Lcn/jpush/android/util/b;->ordinal()I

    move-result v0

    sput v0, Lcn/jpush/android/util/a;->a:I

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {p0}, Lcn/jpush/android/util/a;->B(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    :cond_9
    move-object v0, v1

    goto :goto_3
.end method

.method private static l(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    new-instance v1, Landroid/content/ComponentName;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v2, 0x80

    :try_start_0
    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getServiceInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ServiceInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static m(Landroid/content/Context;)V
    .locals 4

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x38

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    const/4 v1, 0x1

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x39

    aget-object v2, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/PowerManager$WakeLock;->setReferenceCounted(Z)V

    invoke-static {}, Lcn/jpush/android/service/r;->a()Lcn/jpush/android/service/r;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcn/jpush/android/service/r;->a(Landroid/os/PowerManager$WakeLock;)V

    invoke-static {}, Lcn/jpush/android/service/r;->a()Lcn/jpush/android/service/r;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/service/r;->b()Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->isHeld()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcn/jpush/android/service/r;->a()Lcn/jpush/android/service/r;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/service/r;->b()Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->acquire()V

    :cond_0
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    return-void
.end method

.method private static m(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 3

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    new-instance v1, Landroid/content/ComponentName;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, p1}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v2, 0x80

    :try_start_0
    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getActivityInfo(Landroid/content/ComponentName;I)Landroid/content/pm/ActivityInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static n(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;
    .locals 2

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    const/16 v1, 0x100

    invoke-virtual {v0, p1, v1}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v0, p1}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static n(Landroid/content/Context;)Lorg/json/JSONArray;
    .locals 7

    const/4 v0, 0x0

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/pm/PackageManager;->getInstalledPackages(I)Ljava/util/List;

    move-result-object v3

    move v1, v0

    :goto_0
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    invoke-interface {v3, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/PackageInfo;

    new-instance v4, Lcn/jpush/android/util/y;

    invoke-direct {v4}, Lcn/jpush/android/util/y;-><init>()V

    iget-object v5, v0, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/content/pm/ApplicationInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcn/jpush/android/util/y;->a:Ljava/lang/String;

    iget-object v5, v0, Landroid/content/pm/PackageInfo;->packageName:Ljava/lang/String;

    iput-object v5, v4, Lcn/jpush/android/util/y;->b:Ljava/lang/String;

    iget-object v5, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v5, v4, Lcn/jpush/android/util/y;->c:Ljava/lang/String;

    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I

    iput v0, v4, Lcn/jpush/android/util/y;->d:I

    invoke-virtual {v2, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_0
    new-instance v1, Lorg/json/JSONArray;

    invoke-direct {v1}, Lorg/json/JSONArray;-><init>()V

    :try_start_0
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/jpush/android/util/y;

    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v5, 0x1

    aget-object v4, v4, v5

    iget-object v5, v0, Lcn/jpush/android/util/y;->a:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v5, 0x2

    aget-object v4, v4, v5

    iget-object v5, v0, Lcn/jpush/android/util/y;->b:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v5, 0x3

    aget-object v4, v4, v5

    iget-object v5, v0, Lcn/jpush/android/util/y;->c:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v5, 0x0

    aget-object v4, v4, v5

    iget v0, v0, Lcn/jpush/android/util/y;->d:I

    invoke-virtual {v3, v4, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    invoke-virtual {v1, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    :cond_1
    return-object v1
.end method

.method private static o(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    const/4 v0, 0x0

    invoke-static {}, Lcn/jpush/android/util/a;->a()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v1, v1, v2

    invoke-static {p0, v1}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    :cond_0
    move-object p1, v0

    :cond_1
    :goto_0
    return-object p1

    :cond_2
    new-instance v1, Ljava/io/File;

    sget-object v2, Lcn/jpush/android/util/a;->d:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v2

    if-nez v2, :cond_3

    :try_start_0
    invoke-virtual {v1}, Ljava/io/File;->mkdir()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    :cond_3
    :goto_1
    new-instance v2, Ljava/io/File;

    sget-object v1, Lcn/jpush/android/util/a;->f:Ljava/lang/String;

    invoke-direct {v2, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_4

    :try_start_1
    invoke-virtual {v2}, Ljava/io/File;->delete()Z
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_2

    :cond_4
    :try_start_2
    invoke-virtual {v2}, Ljava/io/File;->createNewFile()Z
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3

    :try_start_3
    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/FileOutputStream;->write([B)V

    invoke-virtual {v1}, Ljava/io/FileOutputStream;->flush()V

    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_7
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    if-eqz v1, :cond_1

    :try_start_5
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_0

    :catch_1
    move-exception v1

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    goto :goto_1

    :catch_2
    move-exception v1

    move-object p1, v0

    goto :goto_0

    :catch_3
    move-exception v1

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    move-object p1, v0

    goto :goto_0

    :catch_4
    move-exception v1

    move-object v1, v0

    :goto_2
    :try_start_6
    invoke-static {}, Lcn/jpush/android/util/x;->j()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    if-eqz v1, :cond_5

    :try_start_7
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_5

    :cond_5
    :goto_3
    move-object p1, v0

    goto :goto_0

    :catchall_0
    move-exception v1

    move-object v3, v1

    move-object v1, v0

    move-object v0, v3

    :goto_4
    if-eqz v1, :cond_6

    :try_start_8
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_6

    :cond_6
    :goto_5
    throw v0

    :catch_5
    move-exception v1

    goto :goto_3

    :catch_6
    move-exception v1

    goto :goto_5

    :catchall_1
    move-exception v0

    goto :goto_4

    :catch_7
    move-exception v2

    goto :goto_2
.end method

.method public static o(Landroid/content/Context;)Z
    .locals 10

    const/4 v1, 0x1

    const/4 v0, 0x0

    :try_start_0
    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x14

    aget-object v2, v2, v3

    const-string v3, "0"

    invoke-static {p0, v2, v3}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "1"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    :cond_0
    :goto_0
    return v0

    :cond_1
    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x17

    aget-object v2, v2, v3

    const-string v3, ""

    invoke-static {p0, v2, v3}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    move v0, v1

    goto :goto_0

    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x15

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    const-string v3, "_"

    invoke-virtual {v2, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    aget-object v3, v2, v3

    const/4 v4, 0x1

    aget-object v2, v2, v4

    invoke-virtual {v3}, Ljava/lang/String;->toCharArray()[C

    move-result-object v3

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x16

    aget-object v4, v4, v5

    invoke-virtual {v2, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    const/4 v5, 0x7

    invoke-virtual {v2, v5}, Ljava/util/Calendar;->get(I)I

    move-result v5

    const/16 v6, 0xb

    invoke-virtual {v2, v6}, Ljava/util/Calendar;->get(I)I

    move-result v6

    array-length v7, v3

    move v2, v0

    :goto_1
    if-ge v2, v7, :cond_0

    aget-char v8, v3, v2

    invoke-static {v8}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    add-int/lit8 v8, v8, 0x1

    if-ne v5, v8, :cond_3

    const/4 v8, 0x0

    aget-object v8, v4, v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    const/4 v9, 0x1

    aget-object v9, v4, v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v9

    if-lt v6, v8, :cond_3

    if-gt v6, v9, :cond_3

    move v0, v1

    goto/16 :goto_0

    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :catch_0
    move-exception v0

    move v0, v1

    goto/16 :goto_0
.end method

.method private static p(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x23

    aget-object v0, v0, v1

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x24

    aget-object v1, v1, v2

    invoke-static {v0, v1}, Landroid/provider/Settings$System;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    :cond_0
    :goto_0
    return-object p1

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto :goto_0
.end method

.method public static p(Landroid/content/Context;)Z
    .locals 10

    const/16 v8, 0x3b

    const/16 v9, 0x17

    const/4 v1, 0x1

    const/4 v0, 0x0

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x6e

    aget-object v2, v2, v3

    const-string v3, ""

    invoke-static {p0, v2, v3}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, v2}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x6d

    aget-object v2, v2, v4

    const/4 v4, -0x1

    invoke-virtual {v3, v2, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v2

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x6a

    aget-object v4, v4, v5

    const/4 v5, -0x1

    invoke-virtual {v3, v4, v5}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v4

    sget-object v5, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v6, 0x6c

    aget-object v5, v5, v6

    const/4 v6, -0x1

    invoke-virtual {v3, v5, v6}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v5

    sget-object v6, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v7, 0x6b

    aget-object v6, v6, v7

    const/4 v7, -0x1

    invoke-virtual {v3, v6, v7}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v3

    if-ltz v2, :cond_0

    if-ltz v4, :cond_0

    if-ltz v5, :cond_0

    if-ltz v3, :cond_0

    if-gt v4, v8, :cond_0

    if-gt v3, v8, :cond_0

    if-gt v5, v9, :cond_0

    if-gt v2, v9, :cond_0

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v6

    const/16 v7, 0xb

    invoke-virtual {v6, v7}, Ljava/util/Calendar;->get(I)I

    move-result v7

    const/16 v8, 0xc

    invoke-virtual {v6, v8}, Ljava/util/Calendar;->get(I)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v6

    if-ge v2, v5, :cond_5

    if-le v7, v2, :cond_2

    if-lt v7, v5, :cond_4

    :cond_2
    if-ne v7, v2, :cond_3

    if-ge v6, v4, :cond_4

    :cond_3
    if-ne v7, v5, :cond_0

    if-gt v6, v3, :cond_0

    :cond_4
    move v0, v1

    goto :goto_0

    :cond_5
    if-ne v2, v5, :cond_6

    if-ne v7, v2, :cond_0

    if-lt v6, v4, :cond_0

    if-gt v6, v3, :cond_0

    move v0, v1

    goto :goto_0

    :cond_6
    if-le v2, v5, :cond_0

    if-le v7, v2, :cond_7

    if-le v7, v9, :cond_a

    :cond_7
    if-ltz v7, :cond_8

    if-lt v7, v5, :cond_a

    :cond_8
    if-ne v7, v2, :cond_9

    if-ge v6, v4, :cond_a

    :cond_9
    if-ne v7, v5, :cond_0

    if-gt v6, v3, :cond_0

    :cond_a
    move v0, v1

    goto :goto_0

    :catch_0
    move-exception v1

    goto/16 :goto_0
.end method

.method private static q(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x23

    aget-object v0, v0, v1

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x24

    aget-object v1, v1, v2

    invoke-static {v0, v1, p1}, Landroid/provider/Settings$System;->putString(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-object p1

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    :cond_0
    const/4 p1, 0x0

    goto :goto_0
.end method

.method public static q(Landroid/content/Context;)Z
    .locals 9

    const/16 v8, 0x78

    const/16 v5, 0x74

    const/4 v2, 0x1

    const/4 v1, 0x0

    const/16 v7, 0x27

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x73

    aget-object v3, v3, v4

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    const-class v0, Lcn/jpush/android/service/PushService;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->l(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x70

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-class v4, Lcn/jpush/android/service/PushService;

    invoke-virtual {v4}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    :goto_0
    sget-object v3, Lcn/jpush/android/a;->f:Ljava/lang/String;

    invoke-static {v3}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_11

    move v3, v2

    :goto_1
    sget-boolean v4, Lcn/jpush/android/a;->i:Z

    if-nez v4, :cond_0

    invoke-static {p0}, Lcn/jpush/android/util/a;->D(Landroid/content/Context;)Z

    move-result v4

    if-nez v4, :cond_0

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v4, v4, v7

    sget-object v5, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v6, 0x7a

    aget-object v5, v5, v6

    invoke-static {v4, v5}, Lcn/jpush/android/util/x;->d(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    if-eqz v3, :cond_12

    if-eqz v0, :cond_12

    :goto_2
    return v2

    :cond_1
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x7d

    aget-object v0, v0, v3

    invoke-static {p0, v0, v1}, Lcn/jpush/android/util/a;->b(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x79

    aget-object v3, v3, v4

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto :goto_0

    :cond_2
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x7b

    aget-object v0, v0, v3

    invoke-static {p0, v0, v1}, Lcn/jpush/android/util/a;->b(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x76

    aget-object v3, v3, v4

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto :goto_0

    :cond_3
    const-class v0, Lcn/jpush/android/service/DownloadService;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->l(Landroid/content/Context;Ljava/lang/String;)Z

    const-class v0, Lcn/jpush/android/service/PushReceiver;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->d(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-class v4, Lcn/jpush/android/service/PushReceiver;

    invoke-virtual {v4}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p0}, Lcn/jpush/android/util/a;->E(Landroid/content/Context;)V

    :cond_4
    move v0, v2

    goto/16 :goto_0

    :cond_5
    const-class v0, Lcn/jpush/android/service/PushReceiver;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x75

    aget-object v3, v3, v4

    invoke-static {p0, v0, v3}, Lcn/jpush/android/util/a;->d(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x7e

    aget-object v3, v3, v4

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->d(Ljava/lang/String;Ljava/lang/String;)V

    :cond_6
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x40

    aget-object v0, v0, v3

    invoke-static {p0, v0, v2}, Lcn/jpush/android/util/a;->a(Landroid/content/Context;Ljava/lang/String;Z)Z

    move-result v0

    if-nez v0, :cond_7

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x77

    aget-object v3, v3, v4

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto/16 :goto_0

    :cond_7
    const-class v0, Lcn/jpush/android/service/AlarmReceiver;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->d(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-class v4, Lcn/jpush/android/service/AlarmReceiver;

    invoke-virtual {v4}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto/16 :goto_0

    :cond_8
    const-class v0, Lcn/jpush/android/ui/PushActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->m(Landroid/content/Context;Ljava/lang/String;)Z

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x48

    aget-object v0, v0, v3

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {v3, v4, v1}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_9

    :cond_9
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x7f

    aget-object v3, v3, v4

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->k(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_a

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v3, v3, v7

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v6, 0x80

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto/16 :goto_0

    :cond_a
    sget-object v3, Lcn/jpush/android/util/a;->g:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    sget-object v0, Lcn/jpush/android/util/a;->g:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_b
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v0}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_b

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v3, v3, v7

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v6, 0x71

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto/16 :goto_0

    :cond_c
    invoke-static {p0}, Lcn/jpush/android/util/a;->i(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_d

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x23

    aget-object v3, v3, v4

    invoke-static {v0, v3}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_d

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v7

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x72

    aget-object v3, v3, v4

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto/16 :goto_0

    :cond_d
    sget-object v0, Lcn/jpush/android/util/a;->h:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_e
    :goto_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v0}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_e

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v4, v4, v7

    new-instance v5, Ljava/lang/StringBuilder;

    sget-object v6, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v6, v6, v8

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Lcn/jpush/android/util/x;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    :cond_f
    sget-object v0, Lcn/jpush/android/util/a;->i:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_10
    :goto_4
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v0}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_10

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v4, v4, v7

    new-instance v5, Ljava/lang/StringBuilder;

    sget-object v6, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v6, v6, v8

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v5, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v6, 0x7c

    aget-object v5, v5, v6

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Lcn/jpush/android/util/x;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4

    :cond_11
    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v3, v3, v7

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x6f

    aget-object v4, v4, v5

    invoke-static {v3, v4}, Lcn/jpush/android/util/x;->d(Ljava/lang/String;Ljava/lang/String;)V

    move v3, v1

    goto/16 :goto_1

    :cond_12
    move v2, v1

    goto/16 :goto_2
.end method

.method public static r(Landroid/content/Context;)V
    .locals 1

    sget-object v0, Lcn/jpush/android/util/a;->j:Lcn/jpush/android/service/PushReceiver;

    if-eqz v0, :cond_0

    const-class v0, Lcn/jpush/android/service/PushReceiver;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->d(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    :try_start_0
    sget-object v0, Lcn/jpush/android/util/a;->j:Lcn/jpush/android/service/PushReceiver;

    invoke-virtual {p0, v0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto :goto_0
.end method

.method public static s(Landroid/content/Context;)J
    .locals 2

    invoke-static {p0}, Lcn/jpush/android/service/PushService;->a(Landroid/content/Context;)J

    move-result-wide v0

    return-wide v0
.end method

.method public static t(Landroid/content/Context;)Ljava/lang/String;
    .locals 1

    invoke-static {p0}, Lcn/jpush/android/service/PushService;->b(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static u(Landroid/content/Context;)Ljava/lang/String;
    .locals 2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x62

    aget-object v0, v0, v1

    const-string v1, ""

    invoke-static {p0, v0, v1}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static v(Landroid/content/Context;)Ljava/lang/String;
    .locals 4

    sget-object v0, Lcn/jpush/android/a;->f:Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x80

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v2, v1, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    if-eqz v2, :cond_0

    iget-object v1, v1, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v3, 0x3c

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :cond_0
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public static w(Landroid/content/Context;)Ljava/lang/String;
    .locals 5

    const/4 v4, 0x6

    const/4 v3, 0x1

    const-string v1, ""

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v4

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-nez v0, :cond_0

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x21

    aget-object v0, v0, v1

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    if-ne v2, v3, :cond_1

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x20

    aget-object v0, v0, v1

    goto :goto_0

    :cond_1
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v2

    if-nez v2, :cond_6

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v0

    const/4 v2, 0x4

    if-eq v0, v2, :cond_2

    if-eq v0, v3, :cond_2

    const/4 v2, 0x2

    if-ne v0, v2, :cond_3

    :cond_2
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x22

    aget-object v0, v0, v1

    goto :goto_0

    :cond_3
    const/4 v2, 0x3

    if-eq v0, v2, :cond_4

    const/16 v2, 0x8

    if-eq v0, v2, :cond_4

    if-eq v0, v4, :cond_4

    const/4 v2, 0x5

    if-eq v0, v2, :cond_4

    const/16 v2, 0xc

    if-ne v0, v2, :cond_5

    :cond_4
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x1f

    aget-object v0, v0, v1

    goto :goto_0

    :cond_5
    const/16 v2, 0xd

    if-ne v0, v2, :cond_6

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v1, 0x1e

    aget-object v0, v0, v1

    goto :goto_0

    :cond_6
    move-object v0, v1

    goto :goto_0
.end method

.method private static x(Landroid/content/Context;)Ljava/lang/String;
    .locals 5

    const/4 v1, 0x0

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x47

    aget-object v0, v0, v2

    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x20

    aget-object v0, v0, v2

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/wifi/WifiInfo;->getMacAddress()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    const-string v2, ""

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    :cond_1
    move-object v0, v1

    goto :goto_0

    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x69

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->a(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    move-object v0, v1

    goto :goto_0
.end method

.method private static y(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    const-string v0, ""

    :try_start_0
    invoke-static {p0, v0}, Lcn/jpush/android/util/a;->i(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->d(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    invoke-static {p0}, Lcn/jpush/android/util/a;->k(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    invoke-static {v0}, Lcn/jpush/android/util/a;->d(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v2, 0x3d

    aget-object v1, v1, v2

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    invoke-static {p0}, Lcn/jpush/android/util/a;->x(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    invoke-static {v0}, Lcn/jpush/android/util/a;->d(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    :cond_3
    invoke-static {p0}, Lcn/jpush/android/util/a;->z(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, " "
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    invoke-static {p0}, Lcn/jpush/android/util/a;->z(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static z(Landroid/content/Context;)Ljava/lang/String;
    .locals 7

    const/16 v5, 0x35

    const/16 v4, 0x37

    const/16 v6, 0x36

    const/4 v3, 0x0

    const/4 v2, 0x0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v5

    invoke-virtual {p0, v0, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v1, v1, v4

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    invoke-static {}, Lcn/jpush/android/util/a;->a()Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v5

    invoke-virtual {p0, v0, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v4

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v2, v2, v4

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0

    :cond_2
    sget-object v0, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v0, v0, v6

    invoke-static {p0, v0, v2}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v3, Ljava/io/File;

    sget-object v0, Lcn/jpush/android/util/a;->e:Ljava/lang/String;

    invoke-direct {v3, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_3

    :try_start_0
    new-instance v0, Ljava/io/FileInputStream;

    invoke-direct {v0, v3}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-static {v0}, Lcn/jpush/android/util/m;->a(Ljava/io/InputStream;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lez v1, :cond_3

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v4, 0x36

    aget-object v1, v1, v4

    invoke-static {p0, v1, v0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    const/16 v5, 0x34

    aget-object v4, v4, v5

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    invoke-static {v0}, Ljava/util/UUID;->nameUUIDFromBytes([B)Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/util/a;->z:[Ljava/lang/String;

    aget-object v1, v1, v6

    invoke-static {p0, v1, v0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :try_start_1
    invoke-virtual {v3}, Ljava/io/File;->createNewFile()Z
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    :try_start_2
    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/FileOutputStream;->write([B)V

    invoke-virtual {v1}, Ljava/io/FileOutputStream;->flush()V

    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_6
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    if-eqz v1, :cond_0

    :try_start_4
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    goto/16 :goto_0

    :catch_1
    move-exception v1

    goto/16 :goto_0

    :catch_2
    move-exception v1

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    goto/16 :goto_0

    :catch_3
    move-exception v1

    move-object v1, v2

    :goto_1
    :try_start_5
    invoke-static {}, Lcn/jpush/android/util/x;->j()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    if-eqz v1, :cond_0

    :try_start_6
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_4

    goto/16 :goto_0

    :catch_4
    move-exception v1

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    move-object v1, v2

    :goto_2
    if-eqz v1, :cond_4

    :try_start_7
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_5

    :cond_4
    :goto_3
    throw v0

    :catch_5
    move-exception v1

    goto :goto_3

    :catchall_1
    move-exception v0

    goto :goto_2

    :catch_6
    move-exception v2

    goto :goto_1
.end method

.method private static z([C)Ljava/lang/String;
    .locals 6

    array-length v0, p0

    const/4 v1, 0x0

    const/4 v2, 0x1

    if-gt v0, v2, :cond_2

    :cond_0
    move-object v2, p0

    move v3, v1

    :goto_0
    aget-char v5, p0, v1

    rem-int/lit8 v4, v3, 0x5

    packed-switch v4, :pswitch_data_0

    const/16 v4, 0x39

    :goto_1
    xor-int/2addr v4, v5

    int-to-char v4, v4

    aput-char v4, p0, v1

    add-int/lit8 v1, v3, 0x1

    if-nez v0, :cond_1

    move-object p0, v2

    move v3, v1

    move v1, v0

    goto :goto_0

    :pswitch_0
    const/16 v4, 0x28

    goto :goto_1

    :pswitch_1
    const/16 v4, 0xe

    goto :goto_1

    :pswitch_2
    const/16 v4, 0x5c

    goto :goto_1

    :pswitch_3
    const/16 v4, 0x75

    goto :goto_1

    :cond_1
    move-object p0, v2

    :cond_2
    if-gt v0, v1, :cond_0

    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p0}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    return-object v0

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private static z(Ljava/lang/String;)[C
    .locals 3

    invoke-virtual {p0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    move-object v1, v0

    :goto_0
    array-length v0, v0

    const/4 v2, 0x2

    if-ge v0, v2, :cond_0

    if-eqz v0, :cond_1

    const/4 v0, 0x0

    aget-char v2, v1, v0

    xor-int/lit8 v2, v2, 0x39

    int-to-char v2, v2

    aput-char v2, v1, v0

    :cond_0
    return-object v1

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method
