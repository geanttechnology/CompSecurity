.class public Lcn/jpush/android/service/PushService;
.super Landroid/app/Service;


# static fields
.field public static A:Ljava/lang/String;

.field public static B:Z

.field public static C:Z

.field public static D:I

.field private static E:J

.field private static F:J

.field private static G:Z

.field private static H:Z

.field private static I:Ljava/lang/String;

.field private static J:Ljava/lang/String;

.field private static K:I

.field private static L:Ljava/lang/String;

.field private static M:Ljava/lang/String;

.field private static N:I

.field private static O:I

.field private static P:Ljava/lang/String;

.field private static V:Z

.field private static W:Z

.field private static X:I

.field private static Z:Z

.field public static a:J

.field private static aa:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static aj:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcn/jpush/android/data/e;",
            ">;"
        }
    .end annotation
.end field

.field private static ak:Ljava/lang/String;

.field private static al:Ljava/lang/String;

.field private static am:Ljava/lang/String;

.field public static b:Z

.field private static final bb:[Ljava/lang/String;

.field public static c:Z

.field public static d:I

.field public static e:J

.field public static f:J

.field public static g:J

.field public static h:J

.field public static i:I

.field public static j:J

.field public static k:J

.field public static l:J

.field public static m:J

.field public static n:J

.field public static o:Ljava/lang/String;

.field public static p:I

.field public static q:Z

.field public static r:Z

.field protected static s:J

.field protected static t:Ljava/lang/String;

.field protected static u:Ljava/lang/String;

.field public static z:Z


# instance fields
.field private Q:Lcn/jpush/android/service/n;

.field private R:Z

.field private S:Z

.field private T:Z

.field private U:Z

.field private Y:Lcn/jpush/android/a/d;

.field private ab:I

.field private ac:I

.field private ad:J

.field private ae:J

.field private af:I

.field private ag:I

.field private ah:I

.field private volatile ai:Z

.field private an:Landroid/os/Handler;

.field protected v:I

.field protected w:[B

.field x:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field y:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 12

    const/16 v0, 0xde

    new-array v3, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v1, ")l\tfk?"

    const/4 v0, -0x1

    move-object v4, v3

    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    array-length v5, v1

    const/4 v6, 0x0

    const/4 v7, 0x1

    if-gt v5, v7, :cond_2

    :cond_0
    move-object v7, v1

    move v8, v6

    move v11, v5

    move-object v5, v1

    move v1, v11

    :goto_1
    aget-char v10, v5, v6

    rem-int/lit8 v9, v8, 0x5

    packed-switch v9, :pswitch_data_0

    const/4 v9, 0x2

    :goto_2
    xor-int/2addr v9, v10

    int-to-char v9, v9

    aput-char v9, v5, v6

    add-int/lit8 v6, v8, 0x1

    if-nez v1, :cond_1

    move-object v5, v7

    move v8, v6

    move v6, v1

    goto :goto_1

    :cond_1
    move v5, v1

    move-object v1, v7

    :cond_2
    if-gt v5, v6, :cond_0

    new-instance v5, Ljava/lang/String;

    invoke-direct {v5, v1}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v5}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    packed-switch v0, :pswitch_data_1

    aput-object v1, v3, v2

    const/4 v2, 0x1

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'8iR\u0010L "

    const/4 v0, 0x0

    move-object v3, v4

    goto :goto_0

    :pswitch_0
    aput-object v1, v3, v2

    const/4 v2, 0x2

    const-string v1, "\u001cl\r\u0019\"/j\t\u0019f:}\u0018\u0019d)f\u0014\u0019F\u0019%YMj>)\u001aVw5}YPqa)"

    const/4 v0, 0x1

    move-object v3, v4

    goto :goto_0

    :pswitch_1
    aput-object v1, v3, v2

    const/4 v2, 0x3

    const-string v1, "\u001cl\r\u0019v8yY]c/hY_p4dY}@a)"

    const/4 v0, 0x2

    move-object v3, v4

    goto :goto_0

    :pswitch_2
    aput-object v1, v3, v2

    const/4 v2, 0x4

    const-string v1, "/j\tff:}\u0018"

    const/4 v0, 0x3

    move-object v3, v4

    goto :goto_0

    :pswitch_3
    aput-object v1, v3, v2

    const/4 v2, 0x5

    const-string v1, "\u001e{\u000bVp{}\u0018^c7`\u0018J"

    const/4 v0, 0x4

    move-object v3, v4

    goto :goto_0

    :pswitch_4
    aput-object v1, v3, v2

    const/4 v2, 0x6

    const-string v1, "\u0007-%\u001d"

    const/4 v0, 0x5

    move-object v3, v4

    goto :goto_0

    :pswitch_5
    aput-object v1, v3, v2

    const/4 v2, 0x7

    const-string v1, "(}\u0016IR.z\u0011\u0015"

    const/4 v0, 0x6

    move-object v3, v4

    goto :goto_0

    :pswitch_6
    aput-object v1, v3, v2

    const/16 v2, 0x8

    const-string v1, "\u000b|\nQQ>{\u000fPa>"

    const/4 v0, 0x7

    move-object v3, v4

    goto :goto_0

    :pswitch_7
    aput-object v1, v3, v2

    const/16 v2, 0x9

    const-string v1, "\u0008l\u0017]\"\u0008l\rmc<z8Wf\u001ae\u0010Xq{{\u001cHw>z\r\u0019v4)\n\\p-l\u000b\u0019/{"

    const/16 v0, 0x8

    move-object v3, v4

    goto :goto_0

    :pswitch_8
    aput-object v1, v3, v2

    const/16 v2, 0xa

    const-string v1, ">{\u000bVp("

    const/16 v0, 0x9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9
    aput-object v1, v3, v2

    const/16 v2, 0xb

    const-string v1, "/{\u000c\\"

    const/16 v0, 0xa

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a
    aput-object v1, v3, v2

    const/16 v2, 0xc

    const-string v1, "2z8Wq,l\u000b"

    const/16 v0, 0xb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b
    aput-object v1, v3, v2

    const/16 v2, 0xd

    const-string v1, "(l\u000bOg))\u001aVl=`\u001e\u0019q.j\u001a\\q("

    const/16 v0, 0xc

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c
    aput-object v1, v3, v2

    const/16 v2, 0xe

    const-string v1, "\u001ae\u0018Ko{z\rXp/l\u001d\u0019u2}\u0011\u0019k5}\u001cKt:eC\u0019\'?z"

    const/16 v0, 0xd

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d
    aput-object v1, v3, v2

    const/16 v2, 0xf

    const-string v1, ":e\u0018Ko"

    const/16 v0, 0xe

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_e
    aput-object v1, v3, v2

    const/16 v2, 0x10

    const-string v1, "(}\u0018KP/jYNk/aYTK5}\u001cKt:eY\u0004\""

    const/16 v0, 0xf

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_f
    aput-object v1, v3, v2

    const/16 v2, 0x11

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017A\u0014G7|A\u000f@6w"

    const/16 v0, 0x10

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_10
    aput-object v1, v3, v2

    const/16 v2, 0x12

    const-string v1, "3h\u0017]n>Z\rVr\u000b|\nQ\":y\t\u0015\"(l\u0017]g))\u001cKp4{C\u0019\'()\\J"

    const/16 v0, 0x11

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_11
    aput-object v1, v3, v2

    const/16 v2, 0x13

    const-string v1, "3h\u0017]n>Z\rVr\u000b|\nQ\"(|\u001aZg(zC\u0019"

    const/16 v0, 0x12

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_12
    aput-object v1, v3, v2

    const/16 v2, 0x14

    const-string v1, ":g\u001dKm2mWIg)d\u0010Jq2f\u0017\u0017P\u001eH=fR\u0013F7|]\u0008]8mG"

    const/16 v0, 0x13

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_13
    aput-object v1, v3, v2

    const/16 v2, 0x15

    const-string v1, "\tl\u001ePq/l\u000b\u0019P>j\u000f\u0019d:`\u0015\\f{$YKg/3"

    const/16 v0, 0x14

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_14
    aput-object v1, v3, v2

    const/16 v2, 0x16

    const-string v1, "{d)Vp/)D\u0019"

    const/16 v0, 0x15

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_15
    aput-object v1, v3, v2

    const/16 v2, 0x17

    const-string v1, "j\'N\u00173"

    const/16 v0, 0x16

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_16
    aput-object v1, v3, v2

    const/16 v2, 0x18

    const-string v1, "/f\rVn\u0017l\u0017\u0019?{"

    const/16 v0, 0x17

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_17
    aput-object v1, v3, v2

    const/16 v2, 0x19

    const-string v1, "\tl\u001ePq/l\u000b\u0019e>}YX\">{\u000bVp{j\u0016To:g\u001d\u0019"

    const/16 v0, 0x18

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_18
    aput-object v1, v3, v2

    const/16 v2, 0x1a

    const-string v1, "\u0012g\u0010M\",`\rQ\"v)"

    const/16 v0, 0x19

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_19
    aput-object v1, v3, v2

    const/16 v2, 0x1b

    const-string v1, "?l\u000bOk>@\u001d\u0019?{"

    const/16 v0, 0x1a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1a
    aput-object v1, v3, v2

    const/16 v2, 0x1c

    const-string v1, "\u0011Y,jJ\u0004H)iI\u001eP"

    const/16 v0, 0x1b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1b
    aput-object v1, v3, v2

    const/16 v2, 0x1d

    const-string v1, "\u007f-"

    const/16 v0, 0x1c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1c
    aput-object v1, v3, v2

    const/16 v2, 0x1e

    const-string v1, "\u4e56\u5330\u9134"

    const/16 v0, 0x1d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1d
    aput-object v1, v3, v2

    const/16 v2, 0x1f

    const-string v1, ")l\u001ePq/{\u0018Mk4g&Pf"

    const/16 v0, 0x1e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1e
    aput-object v1, v3, v2

    const/16 v2, 0x20

    const-string v1, ")l\u001ePq/l\u000b\u0019q.j\u001a\\g?3YLk?4"

    const/16 v0, 0x1f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_1f
    aput-object v1, v3, v2

    const/16 v2, 0x21

    const-string v1, ")l\u001ePq/@=\u0019?{"

    const/16 v0, 0x20

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_20
    aput-object v1, v3, v2

    const/16 v2, 0x22

    const-string v1, "\tl\u001ePq/l\u000b\u0003\""

    const/16 v0, 0x21

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_21
    aput-object v1, v3, v2

    const/16 v2, 0x23

    const-string v1, "\u0011Y\u000cJj{|\t]c/lYZm5o\u0010^\"=h\u0010U8"

    const/16 v0, 0x22

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_22
    aput-object v1, v3, v2

    const/16 v2, 0x24

    const-string v1, "\u535e\u5404C\u0019"

    const/16 v0, 0x23

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_23
    aput-object v1, v3, v2

    const/16 v2, 0x25

    const-string v1, "\u000b{\u001c_q\u001d`\u0015\\"

    const/16 v0, 0x24

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_24
    aput-object v1, v3, v2

    const/16 v2, 0x26

    const-string v1, "{\u4e07Yxr+B\u001c@8"

    const/16 v0, 0x25

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_25
    aput-object v1, v3, v2

    const/16 v2, 0x27

    const-string v1, "2g\u000fXn\u0012l\u0014P\"={\u0016T\"(l\u000bOg))R\u0019"

    const/16 v0, 0x26

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_26
    aput-object v1, v3, v2

    const/16 v2, 0x28

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017P\u001eN0jV\tH-pM\u0015"

    const/16 v0, 0x27

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_27
    aput-object v1, v3, v2

    const/16 v2, 0x29

    const-string v1, "+bYOg)z\u0010Vla)"

    const/16 v0, 0x28

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_28
    aput-object v1, v3, v2

    const/16 v2, 0x2a

    const-string v1, "6[\u001cZt\u0019|\u001f_g))D\u0019"

    const/16 v0, 0x29

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_29
    aput-object v1, v3, v2

    const/16 v2, 0x2b

    const-string v1, "\tl\u001ePq/l\u000b\u0019D:`\u0015\\f{~\u0010Mj{l\u000bKm))\u001aVf>3Y"

    const/16 v0, 0x2a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2a
    aput-object v1, v3, v2

    const/16 v2, 0x2c

    const-string v1, "+a\u0016Wg"

    const/16 v0, 0x2b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2b
    aput-object v1, v3, v2

    const/16 v2, 0x2d

    const-string v1, ">{\u000bVp{m\u001cJa)`\tMk4gC3"

    const/16 v0, 0x2c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2c
    aput-object v1, v3, v2

    const/16 v2, 0x2e

    const-string v1, "6@\u0017Mg)\u007f\u0018U"

    const/16 v0, 0x2d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2d
    aput-object v1, v3, v2

    const/16 v2, 0x2f

    const-string v1, "/h\u001eJC5m8Uk:z]\u001d"

    const/16 v0, 0x2e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2e
    aput-object v1, v3, v2

    const/16 v2, 0x30

    const-string v1, "\u0016l\u000b^g?)\rXe\u001ag\u001dxn2h\n\u0019"

    const/16 v0, 0x2f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_2f
    aput-object v1, v3, v2

    const/16 v2, 0x31

    const-string v1, "uy\u001cKo2z\nPm5\'3iW\u0008A&tG\u0008Z8~G"

    const/16 v0, 0x30

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_30
    aput-object v1, v3, v2

    const/16 v2, 0x32

    const-string v1, "6z\u001efk?"

    const/16 v0, 0x31

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_31
    aput-object v1, v3, v2

    const/16 v2, 0x33

    const-string v1, "\u000f`\u0014\\\"/fYIp4j\u001cJq{{\u001cZg2\u007f\u001c]\"6z\u001e\u0017"

    const/16 v0, 0x32

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_32
    aput-object v1, v3, v2

    const/16 v2, 0x34

    const-string v1, "4g)Xp(l8Wf\tl\u001aOO(n4\\q(h\u001e\\\"{d\n^K?)D\u0019"

    const/16 v0, 0x33

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_33
    aput-object v1, v3, v2

    const/16 v2, 0x35

    const-string v1, "\u000fa\u001c\u0019r:j\u0012Xe>)\u0015\\l<a\r\u0019k()C\u0019"

    const/16 v0, 0x34

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_34
    aput-object v1, v3, v2

    const/16 v2, 0x36

    const-string v1, "lo\u001c_4:>\u001d\u000e48>A\u000b`joI\\f:=M\u000f`ijOZ6kh"

    const/16 v0, 0x35

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_35
    aput-object v1, v3, v2

    const/16 v2, 0x37

    const-string v1, "(l\u0017]g)@\u001d"

    const/16 v0, 0x36

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_36
    aput-object v1, v3, v2

    const/16 v2, 0x38

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017P\u001eZ-vP\u001eY,jJ"

    const/16 v0, 0x37

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_37
    aput-object v1, v3, v2

    const/16 v2, 0x39

    const-string v1, "\tl\u001dLr7`\u001aXv>)\u0014Je{$Y"

    const/16 v0, 0x38

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_38
    aput-object v1, v3, v2

    const/16 v2, 0x3a

    const-string v1, "\u001dh\u0010Ug?)\rV\")l\tVp/)\u000b\\a>`\u000f\\f{$Y"

    const/16 v0, 0x39

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_39
    aput-object v1, v3, v2

    const/16 v2, 0x3b

    const-string v1, "+{\u0016Zg(z;Xq2j<Wv2}\u0000\u0019v\"y\u001c\u0003"

    const/16 v0, 0x3a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_3a
    aput-object v1, v3, v2

    const/16 v2, 0x3c

    const-string v1, ":j\rPm53\u0016WP>j\u000fzm6d\u0018Wfa)"

    const/16 v0, 0x3b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_3b
    aput-object v1, v3, v2

    const/16 v2, 0x3d

    const-string v1, "\u0012g\u000fXn2mYCk+O\u0015Xe{`\n\u00198{"

    const/16 v0, 0x3c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_3c
    aput-object v1, v3, v2

    const/16 v2, 0x3e

    const-string v1, "\u000eg\u001cAr>j\r\\fa)\u000cWi5f\u000eW\"6z\u001e\u0019v\"y\u001c\u0019/"

    const/16 v0, 0x3d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_3d
    aput-object v1, v3, v2

    const/16 v2, 0x3f

    const-string v1, "\u0008|\u001aZg>mYMm{{\u001cIm)}YKg8l\u0010Og?)T\u0019"

    const/16 v0, 0x3e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_3e
    aput-object v1, v3, v2

    const/16 v2, 0x40

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'7vV\u0012O0zC\u000f@6w]\u000fP)|"

    const/16 v0, 0x3f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_3f
    aput-object v1, v3, v2

    const/16 v2, 0x41

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017Q\u000fF)iW\u0008A"

    const/16 v0, 0x40

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_40
    aput-object v1, v3, v2

    const/16 v2, 0x42

    const-string v1, "w)\u0014Je\u0018f\u0017Mg5}C"

    const/16 v0, 0x41

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_41
    aput-object v1, v3, v2

    const/16 v2, 0x43

    const-string v1, "!`\t\u007fn:nYPq{3Y"

    const/16 v0, 0x42

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_42
    aput-object v1, v3, v2

    const/16 v2, 0x44

    const-string v1, ":j\rPm53\u000b\\a>`\u000f\\f\u000b|\nQO>z\nXe>)\u0014Je\u0012mY\u0004\""

    const/16 v0, 0x43

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_43
    aput-object v1, v3, v2

    const/16 v2, 0x45

    const-string v1, "w)\n\\l?l\u000bpfa"

    const/16 v0, 0x44

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_44
    aput-object v1, v3, v2

    const/16 v2, 0x46

    const-string v1, "6l\nJc<l"

    const/16 v0, 0x45

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_45
    aput-object v1, v3, v2

    const/16 v2, 0x47

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017L\u0014]0\u007fK\u0018H-pM\u0015V+|A\u001e@/|F\u0004Y+vZ\u0002"

    const/16 v0, 0x46

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_46
    aput-object v1, v3, v2

    const/16 v2, 0x48

    const-string v1, "\u000eg\u0012Wm,gYZo?)T\u0019"

    const/16 v0, 0x47

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_47
    aput-object v1, v3, v2

    const/16 v2, 0x49

    const-string v1, "w)\u0014Je\u0012mY\u0004\""

    const/16 v0, 0x48

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_48
    aput-object v1, v3, v2

    const/16 v2, 0x4a

    const-string v1, "6z\u001em{+lY\u0004\""

    const/16 v0, 0x49

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_49
    aput-object v1, v3, v2

    const/16 v2, 0x4b

    const-string v1, "\u0016l\nJc<lY\u007fk>e\u001dJ\"v)\u0018Ir\u0012mC"

    const/16 v0, 0x4a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_4a
    aput-object v1, v3, v2

    const/16 v2, 0x4c

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017W\u0015[<~K\u0008]+xV\u0012F7"

    const/16 v0, 0x4b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_4b
    aput-object v1, v3, v2

    const/16 v2, 0x4d

    const-string v1, ":y\tpf"

    const/16 v0, 0x4c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_4c
    aput-object v1, v3, v2

    const/16 v2, 0x4e

    const-string v1, "4g=\\q/{\u0016@\"v)\tKm8l\nJK?3"

    const/16 v0, 0x4d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_4d
    aput-object v1, v3, v2

    const/16 v2, 0x4f

    const-string v1, "7f\u001ePl\u0004{\u001cIm)}&Mk6l"

    const/16 v0, 0x4e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_4e
    aput-object v1, v3, v2

    const/16 v2, 0x50

    const-string v1, "(l\u000bOg)]\u0010Tg{4Y"

    const/16 v0, 0x4f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_4f
    aput-object v1, v3, v2

    const/16 v2, 0x51

    const-string v1, "4g+\\a\u001aj\u0012\u0003\"(l\u0008pf{4Y"

    const/16 v0, 0x50

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_50
    aput-object v1, v3, v2

    const/16 v2, 0x52

    const-string v1, "{)Y\u0019p>y\u0016Kv\u000f`\u0014\\\"f)"

    const/16 v0, 0x51

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_51
    aput-object v1, v3, v2

    const/16 v2, 0x53

    const-string v1, "7f\u001ePl\u0004z\u001cKt>{&Mk6l"

    const/16 v0, 0x52

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_52
    aput-object v1, v3, v2

    const/16 v2, 0x54

    const-string v1, "\u000eO"

    const/16 v0, 0x53

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_53
    aput-object v1, v3, v2

    const/16 v2, 0x55

    const-string v1, "2y\n"

    const/16 v0, 0x54

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_54
    aput-object v1, v3, v2

    const/16 v2, 0x56

    const-string v1, "\u000ez\u001c\u0019\"+f\u000bM8{"

    const/16 v0, 0x55

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_55
    aput-object v1, v3, v2

    const/16 v2, 0x57

    const-string v1, "\u001fG*\u0019k5o\u0016\u0019k(3Y"

    const/16 v0, 0x56

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_56
    aput-object v1, v3, v2

    const/16 v2, 0x58

    const-string v1, "\u0008l\r\u0019f>o\u0018Ln/@)\u0019?{"

    const/16 v0, 0x57

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_57
    aput-object v1, v3, v2

    const/16 v2, 0x59

    const-string v1, "6Y\u0016Kv"

    const/16 v0, 0x58

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_58
    aput-object v1, v3, v2

    const/16 v2, 0x5a

    const-string v1, "3}\rI])l\tVp/V\nPq\u0004|\u000bU"

    const/16 v0, 0x59

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_59
    aput-object v1, v3, v2

    const/16 v2, 0x5b

    const-string v1, "\u0007-"

    const/16 v0, 0x5a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_5a
    aput-object v1, v3, v2

    const/16 v2, 0x5c

    const-string v1, "6J\u000cKp>g\rjk(Y\u0016J"

    const/16 v0, 0x5b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_5b
    aput-object v1, v3, v2

    const/16 v2, 0x5d

    const-string v1, "\u000ez\u001c\u0019Q\u0012ZYIm)}C\u0019"

    const/16 v0, 0x5c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_5c
    aput-object v1, v3, v2

    const/16 v2, 0x5e

    const-string v1, "\u0008@*\u0019P>j\u001cPt>mYjv)`\u0017^8{"

    const/16 v0, 0x5d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_5d
    aput-object v1, v3, v2

    const/16 v2, 0x5f

    const-string v1, "\u0008l\r\u0019o\u001fl\u001fXw7})Vp/)D\u0019"

    const/16 v0, 0x5e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_5e
    aput-object v1, v3, v2

    const/16 v2, 0x60

    const-string v1, "\u0008@*\u0019Q.j\u001a\\q("

    const/16 v0, 0x5f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_5f
    aput-object v1, v3, v2

    const/16 v2, 0x61

    const-string v1, "6@)"

    const/16 v0, 0x60

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_60
    aput-object v1, v3, v2

    const/16 v2, 0x62

    const-string v1, "\u001cl\r\u0019q>{\u000f\\p{`\t\u0019g){\u0016K\",`\rQ8{"

    const/16 v0, 0x61

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_61
    aput-object v1, v3, v2

    const/16 v2, 0x63

    const-string v1, ")l\u001a\\k-l\u001d\u001d&"

    const/16 v0, 0x62

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_62
    aput-object v1, v3, v2

    const/16 v2, 0x64

    const-string v1, "+e\u0018Md4{\u0014"

    const/16 v0, 0x63

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_63
    aput-object v1, v3, v2

    const/16 v2, 0x65

    const-string v1, "\u000eg\u0012Wm,g"

    const/16 v0, 0x64

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_64
    aput-object v1, v3, v2

    const/16 v2, 0x66

    const-string v1, "\u000fa\u001c\u0019t>{\nPm5G\u0018Tg{`\n\u0019l4}YOc7`\u001d\u0015\"\u000be\u001cXq>)\u001aQg8bY@m.{Yxl?{\u0016Pf\u0016h\u0017Pd>z\r\u0017z6e"

    const/16 v0, 0x65

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_65
    aput-object v1, v3, v2

    const/16 v2, 0x67

    const-string v1, "+h\u001aRc<lYWc6lC\u0019"

    const/16 v0, 0x66

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_66
    aput-object v1, v3, v2

    const/16 v2, 0x68

    const-string v1, ".`\u001d\u0004\'?"

    const/16 v0, 0x67

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_67
    aput-object v1, v3, v2

    const/16 v2, 0x69

    const-string v1, "(l\u0017]g))0}8{"

    const/16 v0, 0x68

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_68
    aput-object v1, v3, v2

    const/16 v2, 0x6a

    const-string v1, ")l\nIA4m\u001c\u0004\'?"

    const/16 v0, 0x69

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_69
    aput-object v1, v3, v2

    const/16 v2, 0x6b

    const-string v1, ")l\u001ePq/{\u0018Mk4gYpFa)"

    const/16 v0, 0x6a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_6a
    aput-object v1, v3, v2

    const/16 v2, 0x6c

    const-string v1, "~9Ka"

    const/16 v0, 0x6b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_6b
    aput-object v1, v3, v2

    const/16 v2, 0x6d

    const-string v1, ")l\u001ePq/{\u0018Mk4gY_c2e\u001c]8{,\u001d"

    const/16 v0, 0x6c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_6c
    aput-object v1, v3, v2

    const/16 v2, 0x6e

    const-string v1, "\u001dh\u0010Ug?)\rV\"\u001eg\u0018[n>J\u0011Xl5l\u0015\u0019/{{\u001cM8{"

    const/16 v0, 0x6d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_6d
    aput-object v1, v3, v2

    const/16 v2, 0x6f

    const-string v1, "6O\u0010Kq/E\u0016^e>m0W"

    const/16 v0, 0x6e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_6e
    aput-object v1, v3, v2

    const/16 v2, 0x70

    const-string v1, "\u0012g\u000fXn2mY}g\u0018a\u0018Wl>eYZm6d\u0018Wfa)"

    const/16 v0, 0x6f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_6f
    aput-object v1, v3, v2

    const/16 v2, 0x71

    const-string v1, ")l\tVp/"

    const/16 v0, 0x70

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_70
    aput-object v1, v3, v2

    const/16 v2, 0x72

    const-string v1, "2z+\\q/h\u000bMP/j"

    const/16 v0, 0x71

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_71
    aput-object v1, v3, v2

    const/16 v2, 0x73

    const-string v1, "=h\u0015Jg"

    const/16 v0, 0x72

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_72
    aput-object v1, v3, v2

    const/16 v2, 0x74

    const-string v1, ">g\u0018[n>J\u0011Xl5l\u0015"

    const/16 v0, 0x73

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_73
    aput-object v1, v3, v2

    const/16 v2, 0x75

    const-string v1, "/h\u001eJC5m8Uk:z"

    const/16 v0, 0x74

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_74
    aput-object v1, v3, v2

    const/16 v2, 0x76

    const-string v1, "\u0008|\u001aZg>mYMm{z\rVr\u000b|\nQ\"v)"

    const/16 v0, 0x75

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_75
    aput-object v1, v3, v2

    const/16 v2, 0x77

    const-string v1, "\u0008|\u001aZg>mYMm{L\u0017X`7l:Qc5g\u001cU\"v)"

    const/16 v0, 0x76

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_76
    aput-object v1, v3, v2

    const/16 v2, 0x78

    const-string v1, "(}\u0016IR.z\u0011"

    const/16 v0, 0x77

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_77
    aput-object v1, v3, v2

    const/16 v2, 0x79

    const-string v1, "\u001dh\u0010Ug?)\rV\"(}\u0016IR.z\u0011\u0019/{{\u001cM8{"

    const/16 v0, 0x78

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_78
    aput-object v1, v3, v2

    const/16 v2, 0x7a

    const-string v1, "\u0012g\u000fXn2mYJg/]\u0018^q\u001ag\u001dxk:zYZm6d\u0018Wfa)"

    const/16 v0, 0x79

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_79
    aput-object v1, v3, v2

    const/16 v2, 0x7b

    const-string v1, ":y\tPf"

    const/16 v0, 0x7a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_7a
    aput-object v1, v3, v2

    const/16 v2, 0x7c

    const-string v1, "+|\nQV2d\u001c"

    const/16 v0, 0x7b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_7b
    aput-object v1, v3, v2

    const/16 v2, 0x7d

    const-string v1, ")l\u001a\\k-l\u001d"

    const/16 v0, 0x7c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_7c
    aput-object v1, v3, v2

    const/16 v2, 0x7e

    const-string v1, "{3Y"

    const/16 v0, 0x7d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_7d
    aput-object v1, v3, v2

    const/16 v2, 0x7f

    const-string v1, "\u0012g\u000fXn2mYKg+f\u000bM\")l\u001a\\k-l\u001d\u0019a4d\u0014Xl?3Y"

    const/16 v0, 0x7e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_7e
    aput-object v1, v3, v2

    const/16 v2, 0x80

    const-string v1, "\u001dh\u0010Ug?)\rV\"(l\r\u0019r.z\u0011mk6lY\u0014\")l\r\u0003\""

    const/16 v0, 0x7f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_7f
    aput-object v1, v3, v2

    const/16 v2, 0x81

    const-string v1, "\u0008|\u001aZg>mYMm{z\u001cM\"+|\nQV2d\u001c\u0019/{"

    const/16 v0, 0x80

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_80
    aput-object v1, v3, v2

    const/16 v2, 0x82

    const-string v1, "v$T"

    const/16 v0, 0x81

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_81
    aput-object v1, v3, v2

    const/16 v2, 0x83

    const-string v1, "\u0013h\u0017]n2g\u001e\u0019p>x\u000c\\q/3Y"

    const/16 v0, 0x82

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_82
    aput-object v1, v3, v2

    const/16 v2, 0x84

    const-string v1, "\u0012g\u000fXn2mYJg/)\tLq3]\u0010Tg{j\u0016To:g\u001d\u0003\""

    const/16 v0, 0x83

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_83
    aput-object v1, v3, v2

    const/16 v2, 0x85

    const-string v1, "\u0012g\u000fXn2mY|l:k\u0015\\A3h\u0017Wg7)\u001aVo6h\u0017]8{"

    const/16 v0, 0x84

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_84
    aput-object v1, v3, v2

    const/16 v2, 0x86

    const-string v1, "\u001dh\u0010Ug?)\rV\"(l\r\u0019v:n\nxl?H\u0015Pc()T\u0019p>}C\u0019"

    const/16 v0, 0x85

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_85
    aput-object v1, v3, v2

    const/16 v2, 0x87

    const-string v1, "\u0008|\u001aZg>mYMm{{\u001cIm)}YPl=fY\u0014\""

    const/16 v0, 0x86

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_86
    aput-object v1, v3, v2

    const/16 v2, 0x88

    const-string v1, "\u001dh\u0010Ug?)\rV\")l\tVp/)\u0010Wd4)T\u0019p>}C"

    const/16 v0, 0x87

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_87
    aput-object v1, v3, v2

    const/16 v2, 0x89

    const-string v1, "(l\u0017]g)`\u001d"

    const/16 v0, 0x88

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_88
    aput-object v1, v3, v2

    const/16 v2, 0x8a

    const-string v1, ")}\u001a\u0019k5)"

    const/16 v0, 0x89

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_89
    aput-object v1, v3, v2

    const/16 v2, 0x8b

    const-string v1, "{e\u0018Mg)"

    const/16 v0, 0x8a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_8a
    aput-object v1, v3, v2

    const/16 v2, 0x8c

    const-string v1, "\u0008l\r\u0019o\u0008}\u0018Kv\u0014g,Jg)Y\u000b\\q>g\r\u0019v4)"

    const/16 v0, 0x8b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_8b
    aput-object v1, v3, v2

    const/16 v2, 0x8d

    const-string v1, ">q\u0010M"

    const/16 v0, 0x8c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_8c
    aput-object v1, v3, v2

    const/16 v2, 0x8e

    const-string v1, "\u0008l\r\u0019Q\u000fH+m]\u0008L+oK\u0018L&vL\u0004F)|L{}\u0016\u0019"

    const/16 v0, 0x8d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_8d
    aput-object v1, v3, v2

    const/16 v2, 0x8f

    const-string v1, ".z\t"

    const/16 v0, 0x8e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_8e
    aput-object v1, v3, v2

    const/16 v2, 0x90

    const-string v1, "(g\u001a"

    const/16 v0, 0x8f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_8f
    aput-object v1, v3, v2

    const/16 v2, 0x91

    const-string v1, ")}\u001a"

    const/16 v0, 0x90

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_90
    aput-object v1, v3, v2

    const/16 v2, 0x92

    const-string v1, "6Z\rXp/F\u0017lq>{)Kg(l\u0017M"

    const/16 v0, 0x91

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_91
    aput-object v1, v3, v2

    const/16 v2, 0x93

    const-string v1, "(z\u0016V"

    const/16 v0, 0x92

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_92
    aput-object v1, v3, v2

    const/16 v2, 0x94

    const-string v1, "\u0008l\r\u0019o\u0008}\u0018Kv\u0014g7\\v,f\u000bRA4g\u0017\\a/l\u001d\u0019v4)"

    const/16 v0, 0x93

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_93
    aput-object v1, v3, v2

    const/16 v2, 0x95

    const-string v1, "\u000ey\u001dXv>)\u000bMa{`\u0017Mg)\u007f\u0018U\"/fY"

    const/16 v0, 0x94

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_94
    aput-object v1, v3, v2

    const/16 v2, 0x96

    const-string v1, ")l\tVp/%"

    const/16 v0, 0x95

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_95
    aput-object v1, v3, v2

    const/16 v2, 0x97

    const-string v1, "\u000fa\u001c\u0019q>{\u000fPa>)\u000ePn7)\u0012Pn7)\u0010Mq>e\u001f\u0019k5)"

    const/16 v0, 0x96

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_96
    aput-object v1, v3, v2

    const/16 v2, 0x98

    const-string v1, "\u65ad\u95fd\uff63\u0019"

    const/16 v0, 0x97

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_97
    aput-object v1, v3, v2

    const/16 v2, 0x99

    const-string v1, "?l\u000ffk5o\u0016fp>y&Mk6l"

    const/16 v0, 0x98

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_98
    aput-object v1, v3, v2

    const/16 v2, 0x9a

    const-string v1, "6]\u0011Kg:mYPq{g\u0016M\"2z8Uk-lU\u0019p>z\rXp/)\rQg{}\u0011Kg:mU\u0019k?)D\u0019"

    const/16 v0, 0x99

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_99
    aput-object v1, v3, v2

    const/16 v2, 0x9b

    const-string v1, "\"p\u0000@/\u0016DT]f{A1\u0003o63\nJ"

    const/16 v0, 0x9a

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9a
    aput-object v1, v3, v2

    const/16 v2, 0x9c

    const-string v1, "7j\rPo>"

    const/16 v0, 0x9b

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9b
    aput-object v1, v3, v2

    const/16 v2, 0x9d

    const-string v1, "v$T\u0014/v"

    const/16 v0, 0x9c

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9c
    aput-object v1, v3, v2

    const/16 v2, 0x9e

    const-string v1, "V\u0003"

    const/16 v0, 0x9d

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9d
    aput-object v1, v3, v2

    const/16 v2, 0x9f

    const-string v1, "6]\u0011Kg:mYPq{g\u000cUnw)\u000b\\q/h\u000bM\"/a\u001c\u0019v3{\u001cXfw)\u0010]\"f)"

    const/16 v0, 0x9e

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9e
    aput-object v1, v3, v2

    const/16 v2, 0xa0

    const-string v1, "6]\u0011Kg:mYPq{h\u0015Pt>)\u0010]\"f)"

    const/16 v0, 0x9f

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_9f
    aput-object v1, v3, v2

    const/16 v2, 0xa1

    const-string v1, "2z>\\v\u001cf\u0016^n>H\u001d]p>z\n\u0003\""

    const/16 v0, 0xa0

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a0
    aput-object v1, v3, v2

    const/16 v2, 0xa2

    const-string v1, "2z>\\v\u001cf\u0016^n>H\u001d]p>z\n"

    const/16 v0, 0xa1

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a1
    aput-object v1, v3, v2

    const/16 v2, 0xa3

    const-string v1, "8f\u0015m{+l"

    const/16 v0, 0xa2

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a2
    aput-object v1, v3, v2

    const/16 v2, 0xa4

    const-string v1, "2z5Va:}\u0010Vl\u001eg\u0018[n>m"

    const/16 v0, 0xa3

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a3
    aput-object v1, v3, v2

    const/16 v2, 0xa5

    const-string v1, ",`\u001fP]/f\u000e\\p("

    const/16 v0, 0xa4

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a4
    aput-object v1, v3, v2

    const/16 v2, 0xa6

    const-string v1, "8l\u0015U]/f\u000e\\p("

    const/16 v0, 0xa5

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a5
    aput-object v1, v3, v2

    const/16 v2, 0xa7

    const-string v1, ":f\u000e"

    const/16 v0, 0xa6

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a6
    aput-object v1, v3, v2

    const/16 v2, 0xa8

    const-string v1, ":e\u0015"

    const/16 v0, 0xa7

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a7
    aput-object v1, v3, v2

    const/16 v2, 0xa9

    const-string v1, "<y\n"

    const/16 v0, 0xa8

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a8
    aput-object v1, v3, v2

    const/16 v2, 0xaa

    const-string v1, "7f\u001am{+l"

    const/16 v0, 0xa9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_a9
    aput-object v1, v3, v2

    const/16 v2, 0xab

    const-string v1, "/h\u001eXn2h\n\u0019?{"

    const/16 v0, 0xaa

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_aa
    aput-object v1, v3, v2

    const/16 v2, 0xac

    const-string v1, ":e\u0010Xq"

    const/16 v0, 0xab

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_ab
    aput-object v1, v3, v2

    const/16 v2, 0xad

    const-string v1, "/h\u001eJ"

    const/16 v0, 0xac

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_ac
    aput-object v1, v3, v2

    const/16 v2, 0xae

    const-string v1, ":y\t\u0019r:j\u0012Xe>)\u0017Xo>)\u0015\\l<}\u0011\u0019?{)"

    const/16 v0, 0xad

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_ad
    aput-object v1, v3, v2

    const/16 v2, 0xaf

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'+|E\u0012Z-kC\u000f@6w]\u0012M"

    const/16 v0, 0xae

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_ae
    aput-object v1, v3, v2

    const/16 v2, 0xb0

    const-string v1, "(l\u000bOk8l&Kg<`\nMg)"

    const/16 v0, 0xaf

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_af
    aput-object v1, v3, v2

    const/16 v2, 0xb1

    const-string v1, "~zWIg)d\u0010Jq2f\u0017\u0017H\u000b\\*q]\u0016L*jC\u001cL"

    const/16 v0, 0xb0

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b0
    aput-object v1, v3, v2

    const/16 v2, 0xb2

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\':vL\u0015L:mK\u0014G&zJ\u001aG>|"

    const/16 v0, 0xb1

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b1
    aput-object v1, v3, v2

    const/16 v2, 0xb3

    const-string v1, "(l\u000bOk8l&Zm5g\u001cZg/"

    const/16 v0, 0xb2

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b2
    aput-object v1, v3, v2

    const/16 v2, 0xb4

    const-string v1, "w)\u000b\\va"

    const/16 v0, 0xb3

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b3
    aput-object v1, v3, v2

    const/16 v2, 0xb5

    const-string v1, "\u001dh\u0010Ug?)\rV\")l\tVp/)\t\\p6`\nJk4gYPl=fY\u0014\"+h\u001e\\8{"

    const/16 v0, 0xb4

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b4
    aput-object v1, v3, v2

    const/16 v2, 0xb6

    const-string v1, " +\rVv:e[\u0003\'?%[Ic<l[\u0003\'?%[Jg5m\u001cKk?+C\u001b\'(+U\u001bw2m[\u0003\'(%[Ig)d\u0010Jq2f\u0017fn2z\r\u001b8~z\u0004"

    const/16 v0, 0xb5

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b5
    aput-object v1, v3, v2

    const/16 v2, 0xb7

    const-string v1, "w+"

    const/16 v0, 0xb6

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b6
    aput-object v1, v3, v2

    const/16 v2, 0xb8

    const-string v1, "\u001eg\u0018[n>J\u0011Xl5l\u0015kg*|\u001cJv{h\tI.{z\u001cWf>{Y\\p)f\u000b\u0003\"~zY\u001cq"

    const/16 v0, 0xb7

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b7
    aput-object v1, v3, v2

    const/16 v2, 0xb9

    const-string v1, "\u001eg\u0018[n>):Qc5g\u001cU\"(|\u001aZg(zC\u0019"

    const/16 v0, 0xb8

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b8
    aput-object v1, v3, v2

    const/16 v2, 0xba

    const-string v1, "\u001ae\u000b\\c?pYum<n\u001c]\"\u0012g"

    const/16 v0, 0xb9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_b9
    aput-object v1, v3, v2

    const/16 v2, 0xbb

    const-string v1, "7f\u001am{+l\n\u0019k(3Y"

    const/16 v0, 0xba

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_ba
    aput-object v1, v3, v2

    const/16 v2, 0xbc

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017R\u000eZ1fV\u0012D<"

    const/16 v0, 0xbb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_bb
    aput-object v1, v3, v2

    const/16 v2, 0xbd

    const-string v1, "(l\u0008fk?"

    const/16 v0, 0xbc

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_bc
    aput-object v1, v3, v2

    const/16 v2, 0xbe

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017P\u001eN0jV\u001e["

    const/16 v0, 0xbd

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_bd
    aput-object v1, v3, v2

    const/16 v2, 0xbf

    const-string v1, "\u0007$"

    const/16 v0, 0xbe

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_be
    aput-object v1, v3, v2

    const/16 v2, 0xc0

    const-string v1, "\u0008l\u000bOk8lY[w5m\u0015\\\"v)"

    const/16 v0, 0xbf

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_bf
    aput-object v1, v3, v2

    const/16 v2, 0xc1

    const-string v1, "=f\u000bNc)mYXa/`\u0016W8{"

    const/16 v0, 0xc0

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c0
    aput-object v1, v3, v2

    const/16 v2, 0xc2

    const-string v1, ")l\nMc)}&Kv8"

    const/16 v0, 0xc1

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c1
    aput-object v1, v3, v2

    const/16 v2, 0xc3

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017P\u001eY6kV"

    const/16 v0, 0xc2

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c2
    aput-object v1, v3, v2

    const/16 v2, 0xc4

    const-string v1, "(}\u0016I]/a\u000b\\c?"

    const/16 v0, 0xc3

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c3
    aput-object v1, v3, v2

    const/16 v2, 0xc5

    const-string v1, ":y\t"

    const/16 v0, 0xc4

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c4
    aput-object v1, v3, v2

    const/16 v2, 0xc6

    const-string v1, "3h\u0017]n>Z\u001cMR.z\u0011mk6lYJw8j\u001cJq{$Y"

    const/16 v0, 0xc5

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c5
    aput-object v1, v3, v2

    const/16 v2, 0xc7

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017C\u0017@8j]\u000fH>j"

    const/16 v0, 0xc6

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c6
    aput-object v1, v3, v2

    const/16 v2, 0xc8

    const-string v1, "\u001ae\u000b\\c?pYjg/Y\u000cJj\u000f`\u0014\\.{n\u0010Og{|\t\u0019/{"

    const/16 v0, 0xc7

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c7
    aput-object v1, v3, v2

    const/16 v2, 0xc9

    const-string v1, "+|\nQv2d\u001c"

    const/16 v0, 0xc8

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c8
    aput-object v1, v3, v2

    const/16 v2, 0xca

    const-string v1, "+|\nQV2d\u001c\u001d&"

    const/16 v0, 0xc9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_c9
    aput-object v1, v3, v2

    const/16 v2, 0xcb

    const-string v1, ".z\u001cK]<{\u0016Ll?"

    const/16 v0, 0xca

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_ca
    aput-object v1, v3, v2

    const/16 v2, 0xcc

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017K\u0015@-"

    const/16 v0, 0xcb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_cb
    aput-object v1, v3, v2

    const/16 v2, 0xcd

    const-string v1, "8e\u0016Jg+|\nQ"

    const/16 v0, 0xcc

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_cc
    aput-object v1, v3, v2

    const/16 v2, 0xce

    const-string v1, ":j\rPm53\u0011Xl?e\u001cpl=f+\\r4{\r\u0019/{"

    const/16 v0, 0xcd

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_cd
    aput-object v1, v3, v2

    const/16 v2, 0xcf

    const-string v1, "\u0007V"

    const/16 v0, 0xce

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_ce
    aput-object v1, v3, v2

    const/16 v2, 0xd0

    const-string v1, "8gWSr.z\u0011\u0017c5m\u000bVk?\'\u0010Wv>g\r\u0017W\u0008L+fE\tF,wF"

    const/16 v0, 0xcf

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_cf
    aput-object v1, v3, v2

    const/16 v2, 0xd1

    const-string v1, "w)"

    const/16 v0, 0xd0

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d0
    aput-object v1, v3, v2

    const/16 v2, 0xd2

    const-string v1, "6J\u0016Wl>j\rPm5)D\u0019"

    const/16 v0, 0xd1

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d1
    aput-object v1, v3, v2

    const/16 v2, 0xd3

    const-string v1, "4g*Mc)}:Vo6h\u0017]\"v)\nMc)}0]8"

    const/16 v0, 0xd2

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d2
    aput-object v1, v3, v2

    const/16 v2, 0xd4

    const-string v1, ")}\u001aff>e\u0018@"

    const/16 v0, 0xd3

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d3
    aput-object v1, v3, v2

    const/16 v2, 0xd5

    const-string v1, ">g\u0018[n>J\u0011Xl5l\u0015\u0015"

    const/16 v0, 0xd4

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d4
    aput-object v1, v3, v2

    const/16 v2, 0xd6

    const-string v1, "8f\u001d\\"

    const/16 v0, 0xd5

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d5
    aput-object v1, v3, v2

    const/16 v2, 0xd7

    const-string v1, "5|\u0015U\"8h\u0015U`:j\u0012\u0019\"v)"

    const/16 v0, 0xd6

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d6
    aput-object v1, v3, v2

    const/16 v2, 0xd8

    const-string v1, "\u0008|\u001aZg>mYNk/aYJg*@\u001d\u0019\"v)"

    const/16 v0, 0xd7

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d7
    aput-object v1, v3, v2

    const/16 v2, 0xd9

    const-string v1, "(l\u0008Lg5j\u001c"

    const/16 v0, 0xd8

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d8
    aput-object v1, v3, v2

    const/16 v2, 0xda

    const-string v1, "4g=Pq8f\u0017Wg8}\u001c]"

    const/16 v0, 0xd9

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_d9
    aput-object v1, v3, v2

    const/16 v2, 0xdb

    const-string v1, "4g=Pq8f\u0017Wg8}\u001c]\":g\u001d\u0019p>}\u000b@\"\u0016Z>fI\u001eL)fC\u0017@/|]\u0015F4xN{"

    const/16 v0, 0xda

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_da
    aput-object v1, v3, v2

    const/16 v2, 0xdc

    const-string v1, "<f\u0016Wa3l\u001aR,8f\u0014\u001d"

    const/16 v0, 0xdb

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_db
    aput-object v1, v3, v2

    const/16 v2, 0xdd

    const-string v1, ">h\n@v4d\u001cJq:n\u001c\u0017a4d]"

    const/16 v0, 0xdc

    move-object v3, v4

    goto/16 :goto_0

    :pswitch_dc
    aput-object v1, v3, v2

    sput-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v0, 0x0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->b:Z

    const/4 v0, 0x0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->c:Z

    const/4 v0, 0x2

    sput v0, Lcn/jpush/android/service/PushService;->d:I

    const-wide/32 v0, 0x6ddd00

    sput-wide v0, Lcn/jpush/android/service/PushService;->e:J

    const-wide/32 v0, 0x5265c00

    sput-wide v0, Lcn/jpush/android/service/PushService;->f:J

    const-wide/32 v0, 0x493e0

    sput-wide v0, Lcn/jpush/android/service/PushService;->g:J

    const-wide/32 v0, 0x36ee80

    sput-wide v0, Lcn/jpush/android/service/PushService;->h:J

    const/16 v0, 0x12c

    sput v0, Lcn/jpush/android/service/PushService;->i:I

    const-wide/16 v0, 0x0

    sput-wide v0, Lcn/jpush/android/service/PushService;->j:J

    const-wide/16 v0, 0x0

    sput-wide v0, Lcn/jpush/android/service/PushService;->k:J

    const-wide/16 v0, 0x0

    sput-wide v0, Lcn/jpush/android/service/PushService;->l:J

    const-wide/16 v0, 0x0

    sput-wide v0, Lcn/jpush/android/service/PushService;->m:J

    const-wide/16 v0, 0x0

    sput-wide v0, Lcn/jpush/android/service/PushService;->n:J

    const-wide/32 v0, 0x15180

    sput-wide v0, Lcn/jpush/android/service/PushService;->E:J

    const-wide/16 v0, 0x168

    sput-wide v0, Lcn/jpush/android/service/PushService;->F:J

    const/4 v0, 0x0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->G:Z

    const/4 v0, 0x1

    sput-boolean v0, Lcn/jpush/android/service/PushService;->H:Z

    const-string v1, "j8H\u00173h\'M\u000e,n="

    const/4 v0, -0x1

    :goto_3
    invoke-virtual {v1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v1

    array-length v2, v1

    const/4 v3, 0x0

    const/4 v4, 0x1

    if-gt v2, v4, :cond_5

    :cond_3
    move-object v4, v1

    move v5, v3

    move v11, v2

    move-object v2, v1

    move v1, v11

    :goto_4
    aget-char v7, v2, v3

    rem-int/lit8 v6, v5, 0x5

    packed-switch v6, :pswitch_data_2

    const/4 v6, 0x2

    :goto_5
    xor-int/2addr v6, v7

    int-to-char v6, v6

    aput-char v6, v2, v3

    add-int/lit8 v3, v5, 0x1

    if-nez v1, :cond_4

    move-object v2, v4

    move v5, v3

    move v3, v1

    goto :goto_4

    :pswitch_dd
    const/16 v9, 0x5b

    goto/16 :goto_2

    :pswitch_de
    const/16 v9, 0x9

    goto/16 :goto_2

    :pswitch_df
    const/16 v9, 0x79

    goto/16 :goto_2

    :pswitch_e0
    const/16 v9, 0x39

    goto/16 :goto_2

    :pswitch_e1
    const/16 v6, 0x5b

    goto :goto_5

    :pswitch_e2
    const/16 v6, 0x9

    goto :goto_5

    :pswitch_e3
    const/16 v6, 0x79

    goto :goto_5

    :pswitch_e4
    const/16 v6, 0x39

    goto :goto_5

    :cond_4
    move v2, v1

    move-object v1, v4

    :cond_5
    if-gt v2, v3, :cond_3

    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v1}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v2}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    packed-switch v0, :pswitch_data_3

    sput-object v1, Lcn/jpush/android/service/PushService;->o:Ljava/lang/String;

    const/16 v0, 0xbb8

    sput v0, Lcn/jpush/android/service/PushService;->p:I

    const-string v1, "j8N\u00173h<W\u00084k\'M\u000e"

    const/4 v0, 0x0

    goto :goto_3

    :pswitch_e5
    sput-object v1, Lcn/jpush/android/service/PushService;->I:Ljava/lang/String;

    const-string v1, "2dO\r,1y\u000cJjuj\u0017"

    const/4 v0, 0x1

    goto :goto_3

    :pswitch_e6
    sput-object v1, Lcn/jpush/android/service/PushService;->J:Ljava/lang/String;

    const/16 v0, 0xbb8

    sput v0, Lcn/jpush/android/service/PushService;->K:I

    const-string v1, "(\'\u0013Iw(aWZl"

    const/4 v0, 0x2

    goto :goto_3

    :pswitch_e7
    sput-object v1, Lcn/jpush/android/service/PushService;->L:Ljava/lang/String;

    const-string v1, "j8H\u00173h\'M\u0001,j9M"

    const/4 v0, 0x3

    goto :goto_3

    :pswitch_e8
    sput-object v1, Lcn/jpush/android/service/PushService;->M:Ljava/lang/String;

    const/16 v0, 0x2328

    sput v0, Lcn/jpush/android/service/PushService;->N:I

    const/4 v0, 0x0

    sput v0, Lcn/jpush/android/service/PushService;->O:I

    const/4 v0, 0x1

    sput-boolean v0, Lcn/jpush/android/service/PushService;->q:Z

    const/4 v0, 0x1

    sput-boolean v0, Lcn/jpush/android/service/PushService;->r:Z

    const-string v1, "5|\u0015U"

    const/4 v0, 0x4

    goto :goto_3

    :pswitch_e9
    sput-object v1, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    const-wide/16 v0, 0x0

    sput-wide v0, Lcn/jpush/android/service/PushService;->s:J

    const/4 v0, 0x0

    sput-object v0, Lcn/jpush/android/service/PushService;->t:Ljava/lang/String;

    const-string v0, ""

    sput-object v0, Lcn/jpush/android/service/PushService;->u:Ljava/lang/String;

    const/4 v0, 0x0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->V:Z

    const/4 v0, 0x0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->W:Z

    const/16 v0, 0xa

    sput v0, Lcn/jpush/android/service/PushService;->X:I

    const/4 v0, 0x0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->z:Z

    const/4 v0, 0x1

    sput-boolean v0, Lcn/jpush/android/service/PushService;->Z:Z

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xa8

    aget-object v0, v0, v1

    sput-object v0, Lcn/jpush/android/service/PushService;->A:Ljava/lang/String;

    const/4 v0, 0x0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->B:Z

    const/4 v0, 0x0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->C:Z

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcn/jpush/android/service/PushService;->aa:Ljava/util/List;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcn/jpush/android/service/PushService;->L:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "$"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/PushService;->M:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    sget-object v0, Lcn/jpush/android/service/PushService;->aa:Ljava/util/List;

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xdd

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/service/PushService;->M:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    sget-object v0, Lcn/jpush/android/service/PushService;->aa:Ljava/util/List;

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xdc

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/service/PushService;->M:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    const/4 v0, 0x0

    sput v0, Lcn/jpush/android/service/PushService;->D:I

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    sput-object v0, Lcn/jpush/android/service/PushService;->aj:Ljava/util/Queue;

    const/4 v0, 0x0

    sput-object v0, Lcn/jpush/android/service/PushService;->ak:Ljava/lang/String;

    const/4 v0, 0x0

    sput-object v0, Lcn/jpush/android/service/PushService;->al:Ljava/lang/String;

    const/4 v0, 0x0

    sput-object v0, Lcn/jpush/android/service/PushService;->am:Ljava/lang/String;

    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_dd
        :pswitch_de
        :pswitch_df
        :pswitch_e0
    .end packed-switch

    :pswitch_data_1
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
        :pswitch_81
        :pswitch_82
        :pswitch_83
        :pswitch_84
        :pswitch_85
        :pswitch_86
        :pswitch_87
        :pswitch_88
        :pswitch_89
        :pswitch_8a
        :pswitch_8b
        :pswitch_8c
        :pswitch_8d
        :pswitch_8e
        :pswitch_8f
        :pswitch_90
        :pswitch_91
        :pswitch_92
        :pswitch_93
        :pswitch_94
        :pswitch_95
        :pswitch_96
        :pswitch_97
        :pswitch_98
        :pswitch_99
        :pswitch_9a
        :pswitch_9b
        :pswitch_9c
        :pswitch_9d
        :pswitch_9e
        :pswitch_9f
        :pswitch_a0
        :pswitch_a1
        :pswitch_a2
        :pswitch_a3
        :pswitch_a4
        :pswitch_a5
        :pswitch_a6
        :pswitch_a7
        :pswitch_a8
        :pswitch_a9
        :pswitch_aa
        :pswitch_ab
        :pswitch_ac
        :pswitch_ad
        :pswitch_ae
        :pswitch_af
        :pswitch_b0
        :pswitch_b1
        :pswitch_b2
        :pswitch_b3
        :pswitch_b4
        :pswitch_b5
        :pswitch_b6
        :pswitch_b7
        :pswitch_b8
        :pswitch_b9
        :pswitch_ba
        :pswitch_bb
        :pswitch_bc
        :pswitch_bd
        :pswitch_be
        :pswitch_bf
        :pswitch_c0
        :pswitch_c1
        :pswitch_c2
        :pswitch_c3
        :pswitch_c4
        :pswitch_c5
        :pswitch_c6
        :pswitch_c7
        :pswitch_c8
        :pswitch_c9
        :pswitch_ca
        :pswitch_cb
        :pswitch_cc
        :pswitch_cd
        :pswitch_ce
        :pswitch_cf
        :pswitch_d0
        :pswitch_d1
        :pswitch_d2
        :pswitch_d3
        :pswitch_d4
        :pswitch_d5
        :pswitch_d6
        :pswitch_d7
        :pswitch_d8
        :pswitch_d9
        :pswitch_da
        :pswitch_db
        :pswitch_dc
    .end packed-switch

    :pswitch_data_2
    .packed-switch 0x0
        :pswitch_e1
        :pswitch_e2
        :pswitch_e3
        :pswitch_e4
    .end packed-switch

    :pswitch_data_3
    .packed-switch 0x0
        :pswitch_e5
        :pswitch_e6
        :pswitch_e7
        :pswitch_e8
        :pswitch_e9
    .end packed-switch
.end method

.method public constructor <init>()V
    .locals 3

    const/4 v2, -0x1

    const/4 v1, 0x0

    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    iput v1, p0, Lcn/jpush/android/service/PushService;->v:I

    const/16 v0, 0x800

    new-array v0, v0, [B

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->w:[B

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    new-instance v0, Ljava/util/concurrent/ConcurrentLinkedQueue;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentLinkedQueue;-><init>()V

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    iput-boolean v1, p0, Lcn/jpush/android/service/PushService;->T:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/jpush/android/service/PushService;->U:Z

    iput v2, p0, Lcn/jpush/android/service/PushService;->ag:I

    iput v2, p0, Lcn/jpush/android/service/PushService;->ah:I

    iput-boolean v1, p0, Lcn/jpush/android/service/PushService;->ai:Z

    new-instance v0, Lcn/jpush/android/service/m;

    invoke-direct {v0, p0}, Lcn/jpush/android/service/m;-><init>(Lcn/jpush/android/service/PushService;)V

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    return-void
.end method

.method private A()V
    .locals 8

    const/4 v7, 0x0

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x10

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v1, Lcn/jpush/android/service/PushService;->i:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget v1, Lcn/jpush/android/service/PushService;->i:I

    sget-boolean v0, Lcn/jpush/android/service/PushService;->H:Z

    sput-boolean v0, Lcn/jpush/android/service/PushService;->H:Z

    if-eqz v0, :cond_0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcn/jpush/android/service/AlarmReceiver;

    invoke-direct {v0, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-static {p0, v7, v0, v7}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xf

    aget-object v0, v0, v3

    invoke-virtual {p0, v0}, Lcn/jpush/android/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    mul-int/lit16 v5, v1, 0x3e8

    int-to-long v5, v5

    add-long/2addr v3, v5

    invoke-virtual {v0, v7, v3, v4, v2}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xe

    aget-object v0, v0, v2

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v2, v7

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    :cond_0
    return-void
.end method

.method private B()V
    .locals 0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->w()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->q()V

    return-void
.end method

.method private C()V
    .locals 2

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3ef

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    return-void
.end method

.method private D()V
    .locals 3

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/service/PushService;->A:Ljava/lang/String;

    sget-boolean v1, Lcn/jpush/android/service/PushService;->C:Z

    sget-boolean v2, Lcn/jpush/android/service/PushService;->B:Z

    invoke-direct {p0, p0, v0, v1, v2}, Lcn/jpush/android/service/PushService;->a(Landroid/content/Context;Ljava/lang/String;ZZ)Lcn/jpush/android/a/d;

    move-result-object v0

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->Y:Lcn/jpush/android/a/d;

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Y:Lcn/jpush/android/a/d;

    invoke-virtual {v0}, Lcn/jpush/android/a/d;->f()V

    return-void
.end method

.method private static a(IJLjava/lang/String;Ljava/lang/String;I)I
    .locals 6

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p4}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x64

    aget-object v1, v1, v2

    const-string v2, "a"

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    if-eqz p0, :cond_0

    const-wide/16 v1, 0x0

    cmp-long v1, p1, v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v4

    move v0, p0

    move-wide v1, p1

    move-object v3, p3

    move v5, p5

    invoke-static/range {v0 .. v5}, Lcn/jpush/android/service/PushProtocol;->TagAlias(IJLjava/lang/String;Ljava/lang/String;I)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    return v0

    :catch_0
    move-exception v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method static synthetic a(Lcn/jpush/android/service/PushService;I)I
    .locals 1

    const/4 v0, 0x0

    iput v0, p0, Lcn/jpush/android/service/PushService;->af:I

    return v0
.end method

.method public static a(Landroid/content/Context;)J
    .locals 4

    sget-wide v0, Lcn/jpush/android/service/PushService;->s:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    sget-wide v0, Lcn/jpush/android/service/PushService;->s:J

    :goto_0
    return-wide v0

    :cond_0
    invoke-static {p0}, Lcn/jpush/android/service/PushService;->c(Landroid/content/Context;)Z

    move-result v0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->V:Z

    sget-wide v0, Lcn/jpush/android/service/PushService;->s:J

    goto :goto_0
.end method

.method static synthetic a(Lcn/jpush/android/service/PushService;J)J
    .locals 2

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcn/jpush/android/service/PushService;->ae:J

    return-wide v0
.end method

.method private a(Landroid/content/Context;Ljava/lang/String;ZZ)Lcn/jpush/android/a/d;
    .locals 6

    new-instance v0, Lcn/jpush/android/service/l;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcn/jpush/android/service/l;-><init>(Lcn/jpush/android/service/PushService;Landroid/content/Context;Ljava/lang/String;ZZ)V

    return-object v0
.end method

.method static synthetic a([BI)Ljava/lang/String;
    .locals 1

    invoke-static {p0, p1}, Lcn/jpush/android/service/PushService;->b([BI)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(I)V
    .locals 0

    sput p0, Lcn/jpush/android/service/PushService;->K:I

    return-void
.end method

.method private a(IJ)V
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x63

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x1d

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    :cond_0
    return-void
.end method

.method private a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 11

    const/4 v1, 0x0

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    invoke-static {p1}, Lcn/jpush/android/util/q;->a(Landroid/content/Context;)[Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_0

    array-length v0, v6

    if-nez v0, :cond_2

    :cond_0
    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    :cond_1
    return-void

    :cond_2
    array-length v7, v6

    const-string v3, "["

    move v0, v1

    move v5, v1

    move v2, v1

    :goto_0
    if-ge v0, v7, :cond_1

    aget-object v4, v6, v0

    if-nez v5, :cond_7

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v8, "\""

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    :goto_1
    add-int/lit8 v4, v0, 0x1

    add-int/lit8 v0, v5, 0x1

    const/16 v5, 0x32

    if-ge v0, v5, :cond_3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v5

    const/16 v8, 0x3e8

    if-gt v5, v8, :cond_3

    if-ne v4, v7, :cond_6

    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "]"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xb6

    aget-object v3, v3, v5

    const/4 v5, 0x5

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v5, v1

    const/4 v8, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v5, v8

    const/4 v8, 0x2

    aput-object p2, v5, v8

    const/4 v8, 0x3

    sget-wide v9, Lcn/jpush/android/service/PushService;->s:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    aput-object v9, v5, v8

    const/4 v8, 0x4

    aput-object v0, v5, v8

    invoke-static {v3, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-boolean v3, Lcn/jpush/android/service/PushService;->W:Z

    if-eqz v3, :cond_4

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->q()V

    :cond_4
    iget v3, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v3}, Lcn/jpush/android/service/n;->isAlive()Z

    move-result v3

    if-eqz v3, :cond_5

    iget v3, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v8, Lcn/jpush/android/service/PushService;->s:J

    const/16 v5, 0x8

    invoke-static {v3, v8, v9, v5, v0}, Lcn/jpush/android/service/PushProtocol;->RepPush(IJBLjava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_5

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v8, 0xb5

    aget-object v5, v5, v8

    invoke-direct {v3, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v8, 0xb4

    aget-object v5, v5, v8

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    :cond_5
    add-int/lit8 v0, v2, 0x1

    const-string v2, "["

    move-object v3, v2

    move v2, v0

    move v0, v1

    :cond_6
    move v5, v0

    move v0, v4

    goto/16 :goto_0

    :cond_7
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v8, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v9, 0xb7

    aget-object v8, v8, v9

    invoke-virtual {v3, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto/16 :goto_1
.end method

.method static synthetic a(Lcn/jpush/android/service/PushService;)V
    .locals 0

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->q()V

    return-void
.end method

.method static synthetic a(Lcn/jpush/android/service/PushService;ZZZ)V
    .locals 2

    const/4 v1, 0x1

    const/4 v0, 0x0

    invoke-direct {p0, v0, v1, v1}, Lcn/jpush/android/service/PushService;->a(ZZZ)V

    return-void
.end method

.method public static a(Ljava/lang/String;)V
    .locals 0

    sput-object p0, Lcn/jpush/android/service/PushService;->I:Ljava/lang/String;

    return-void
.end method

.method private a(Ljava/lang/String;I)V
    .locals 6

    if-eqz p2, :cond_2

    sget-object v0, Lcn/jpush/android/service/ServiceInterface;->d:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/jpush/android/api/b;

    if-eqz v0, :cond_0

    iget-object v0, v0, Lcn/jpush/android/api/b;->c:Lcn/jpush/android/api/TagAliasCallback;

    if-eqz v0, :cond_0

    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    const/16 v1, 0x3ee

    iput v1, v0, Landroid/os/Message;->what:I

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const-wide/16 v2, 0x4e20

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    :cond_0
    move v5, p2

    :goto_0
    sget-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-direct {p0, p1, v0, v5}, Lcn/jpush/android/service/PushService;->b(Ljava/lang/String;Ljava/lang/String;I)V

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_1

    sget-wide v0, Lcn/jpush/android/service/PushService;->s:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_3

    :cond_1
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    :goto_1
    return-void

    :cond_2
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;)S

    move-result v5

    goto :goto_0

    :cond_3
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v1, Lcn/jpush/android/service/PushService;->s:J

    sget-object v3, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    move-object v4, p1

    invoke-static/range {v0 .. v5}, Lcn/jpush/android/service/PushService;->a(IJLjava/lang/String;Ljava/lang/String;I)I

    move-result v0

    if-gez v0, :cond_4

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    goto :goto_1

    :cond_4
    invoke-direct {p0, v5}, Lcn/jpush/android/service/PushService;->h(I)V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x9

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/jpush/android/util/x;->c(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->A()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    :cond_0
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xb8

    aget-object v0, v0, v1

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    :goto_0
    return-void

    :cond_1
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_2

    sget-wide v0, Lcn/jpush/android/service/PushService;->s:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_3

    :cond_2
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-direct {p0, p1, p2}, Lcn/jpush/android/service/PushService;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    goto :goto_0

    :cond_3
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v1, Lcn/jpush/android/service/PushService;->s:J

    invoke-static {v0, v1, v2, p1, p2}, Lcn/jpush/android/service/PushProtocol;->EnChannel(IJLjava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-gez v0, :cond_4

    invoke-direct {p0, p1, p2}, Lcn/jpush/android/service/PushService;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    goto :goto_0

    :cond_4
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xb9

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    goto :goto_0
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 5

    const/4 v4, 0x3

    :try_start_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x2f

    aget-object v2, v2, v3

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v2, 0x6

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    array-length v1, v2

    if-le v1, v4, :cond_1

    const/4 v1, 0x2

    aget-object v1, v2, v1

    invoke-static {v1, p1}, Lcn/jpush/android/service/PushService;->f(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v3, v0}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    const/4 v0, 0x3

    :try_start_1
    aget-object v0, v2, v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {v0}, Lcn/jpush/android/service/ServiceInterface;->b(I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-object p1, v1

    :cond_1
    :goto_0
    :try_start_2
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x2f

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x1d

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x1d

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x30

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    :goto_1
    return-void

    :catch_0
    move-exception v0

    move-object p1, v1

    goto :goto_0

    :catch_1
    move-exception v0

    goto :goto_1
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5

    const/4 v4, 0x0

    const/4 v3, 0x1

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x4c

    aget-object v0, v0, v1

    invoke-virtual {p4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    iput v4, p0, Lcn/jpush/android/service/PushService;->ah:I

    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xb0

    aget-object v1, v1, v2

    iget v2, p0, Lcn/jpush/android/service/PushService;->ah:I

    invoke-static {v0, v1, v2}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    if-eqz p2, :cond_1

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v1, v1, v3

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    :cond_1
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xaf

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {v0, p1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xb1

    aget-object v1, v1, v2

    new-array v2, v3, [Ljava/lang/Object;

    aput-object p1, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcn/jpush/android/service/PushService;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    return-void

    :cond_2
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x28

    aget-object v0, v0, v1

    invoke-virtual {p4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iput v3, p0, Lcn/jpush/android/service/PushService;->ah:I

    goto :goto_0
.end method

.method public static a(Z)V
    .locals 0

    sput-boolean p0, Lcn/jpush/android/service/PushService;->G:Z

    return-void
.end method

.method private a(ZZZ)V
    .locals 11

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-eqz p3, :cond_0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :try_start_0
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x80

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x1c

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    if-eqz p2, :cond_4

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_1

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    invoke-static {v0}, Lcn/jpush/android/service/PushProtocol;->Close(I)I

    move-result v0

    iput v0, p0, Lcn/jpush/android/service/PushService;->v:I

    :cond_1
    invoke-static {}, Lcn/jpush/android/service/PushProtocol;->InitConn()I

    move-result v0

    iput v0, p0, Lcn/jpush/android/service/PushService;->v:I

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->d()V

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x1a

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/service/PushService;->I:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x16

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget v1, Lcn/jpush/android/service/PushService;->K:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-object v1, Lcn/jpush/android/service/PushService;->I:Ljava/lang/String;

    sget v2, Lcn/jpush/android/service/PushService;->K:I

    invoke-static {v0, v1, v2}, Lcn/jpush/android/service/PushProtocol;->InitPush(ILjava/lang/String;I)I

    move-result v0

    if-eqz v0, :cond_4

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_2

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    invoke-static {v0}, Lcn/jpush/android/service/PushProtocol;->Close(I)I

    move-result v0

    iput v0, p0, Lcn/jpush/android/service/PushService;->v:I

    :cond_2
    if-nez p3, :cond_3

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcn/jpush/android/service/PushService;->f(I)V

    :cond_3
    :goto_1
    return-void

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x23

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto :goto_0

    :cond_4
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_3

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x2c

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Lcn/jpush/android/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/util/a;->j(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x14

    aget-object v4, v4, v5

    invoke-static {v3, v4}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1e

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getSubscriberId()Ljava/lang/String;

    move-result-object v0

    :goto_2
    if-nez v1, :cond_5

    const-string v1, " "

    :cond_5
    if-nez v0, :cond_6

    const-string v0, " "

    :cond_6
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getPackageName()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x1d

    aget-object v3, v3, v4

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x1d

    aget-object v1, v1, v3

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x1d

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->u()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x17

    aget-object v1, v1, v2

    invoke-static {v0, v1}, Lcn/jpush/android/util/a;->a(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x22

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x29

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget v6, p0, Lcn/jpush/android/service/PushService;->v:I

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->l(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/util/a;->k(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v7, " "

    invoke-static {v2, v7}, Lcn/jpush/android/util/a;->g(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    const-string v8, " "

    invoke-static {v7, v8}, Lcn/jpush/android/util/a;->i(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_7

    const-string v0, " "

    :cond_7
    invoke-static {v1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_8

    const-string v1, " "

    :cond_8
    invoke-static {v2}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_9

    const-string v2, " "

    :cond_9
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    sget v9, Lcn/jpush/android/util/a;->a:I

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v10, 0x1d

    aget-object v9, v9, v10

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v8, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v9, 0x1d

    aget-object v8, v8, v9

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v7, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v8, 0x1d

    aget-object v7, v7, v8

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0x1d

    aget-object v1, v1, v7

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v6, v3, v4, v5, v0}, Lcn/jpush/android/service/PushProtocol;->RegPush(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    const/4 v1, 0x0

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/16 v3, 0x1e

    invoke-static {v0, v2, v3}, Lcn/jpush/android/service/PushProtocol;->RecvPush(I[BI)I

    move-result v0

    if-lez v0, :cond_1d

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->w:[B

    invoke-static {v0}, Lcn/jpush/android/util/a;->b([B)I

    move-result v0

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    invoke-static {v2}, Lcn/jpush/android/util/a;->c([B)I

    move-result v5

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x18

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x2a

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    invoke-static {v3, v5}, Lcn/jpush/android/service/PushService;->b([BI)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    sget-object v2, Lcn/jpush/android/c;->a:Lcn/jpush/android/c;

    invoke-virtual {v2}, Lcn/jpush/android/c;->ordinal()I

    move-result v2

    if-eq v0, v2, :cond_a

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x19

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_1

    :cond_a
    const/4 v0, 0x0

    :goto_3
    const/4 v2, 0x2

    if-ge v0, v2, :cond_b

    shl-int/lit8 v1, v1, 0x8

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v3, v0, 0x14

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    add-int/2addr v1, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_b
    if-nez v1, :cond_16

    sget v0, Lcn/jpush/android/service/PushService;->i:I

    const v1, 0x15181

    if-ne v0, v1, :cond_c

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x2e

    aget-object v1, v1, v2

    const/16 v2, 0x12c

    invoke-static {v0, v1, v2}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V

    const/16 v0, 0x12c

    sput v0, Lcn/jpush/android/service/PushService;->i:I

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->A()V

    :cond_c
    const-wide/16 v0, 0x0

    const/4 v2, 0x0

    move-wide v3, v0

    :goto_4
    const/16 v0, 0x8

    if-ge v2, v0, :cond_d

    const/16 v0, 0x8

    shl-long v0, v3, v0

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v4, v2, 0x16

    aget-byte v3, v3, v4

    and-int/lit16 v3, v3, 0xff

    int-to-long v3, v3

    add-long/2addr v0, v3

    add-int/lit8 v2, v2, 0x1

    move-wide v3, v0

    goto :goto_4

    :cond_d
    const/4 v0, 0x0

    const/4 v1, 0x0

    move v2, v1

    move v1, v0

    :goto_5
    const/4 v0, 0x2

    if-ge v2, v0, :cond_e

    shl-int/lit8 v0, v1, 0x8

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v6, v2, 0x1e

    aget-byte v1, v1, v6

    and-int/lit16 v1, v1, 0xff

    add-int/2addr v0, v1

    add-int/lit8 v1, v2, 0x1

    move v2, v1

    move v1, v0

    goto :goto_5

    :cond_e
    new-array v2, v1, [B

    const/4 v0, 0x0

    :goto_6
    array-length v6, v2

    if-ge v0, v6, :cond_f

    iget-object v6, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v7, v0, 0x20

    aget-byte v6, v6, v7

    and-int/lit16 v6, v6, 0xff

    int-to-byte v6, v6

    aput-byte v6, v2, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    :cond_f
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>([B)V

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v6, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0x20

    aget-object v6, v6, v7

    invoke-direct {v2, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    sput-wide v3, Lcn/jpush/android/service/PushService;->s:J

    sput-object v0, Lcn/jpush/android/service/PushService;->t:Ljava/lang/String;

    const/4 v0, 0x1

    sput-boolean v0, Lcn/jpush/android/service/PushService;->V:Z

    :try_start_1
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x25

    aget-object v0, v0, v2

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v2}, Lcn/jpush/android/service/PushService;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v0

    const/16 v2, 0x8

    invoke-static {v2}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v2

    sget-wide v3, Lcn/jpush/android/service/PushService;->s:J

    invoke-virtual {v2, v3, v4}, Ljava/nio/ByteBuffer;->putLong(J)Ljava/nio/ByteBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->array()[B

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/io/FileOutputStream;->write([B)V

    sget-object v2, Lcn/jpush/android/service/PushService;->t:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/io/FileOutputStream;->write([B)V

    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    :goto_7
    add-int/lit8 v2, v1, 0x20

    const/4 v1, 0x0

    const/4 v0, 0x0

    :goto_8
    const/4 v3, 0x2

    if-ge v0, v3, :cond_10

    shl-int/lit8 v1, v1, 0x8

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int v4, v2, v0

    aget-byte v3, v3, v4

    and-int/lit16 v3, v3, 0xff

    add-int/2addr v1, v3

    add-int/lit8 v0, v0, 0x1

    goto :goto_8

    :catch_1
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto :goto_7

    :catch_2
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto :goto_7

    :cond_10
    add-int/lit8 v2, v2, 0x2

    new-array v3, v1, [B

    const/4 v0, 0x0

    :goto_9
    array-length v4, v3

    if-ge v0, v4, :cond_11

    iget-object v4, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int v6, v2, v0

    aget-byte v4, v4, v6

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v3, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_9

    :cond_11
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/String;-><init>([B)V

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x21

    aget-object v4, v4, v6

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_12

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x1f

    aget-object v4, v4, v6

    invoke-static {v3, v4, v0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    if-nez p3, :cond_12

    sget-object v3, Lcn/jpush/android/a;->b:Ljava/lang/String;

    sget-object v4, Lcn/jpush/android/a;->f:Ljava/lang/String;

    sget-object v6, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0x28

    aget-object v6, v6, v7

    invoke-direct {p0, v3, v4, v0, v6}, Lcn/jpush/android/service/PushService;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :cond_12
    add-int/2addr v2, v1

    if-ge v2, v5, :cond_3

    const/4 v1, 0x0

    const/4 v0, 0x0

    :goto_a
    const/4 v3, 0x2

    if-ge v0, v3, :cond_13

    shl-int/lit8 v1, v1, 0x8

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int v4, v2, v0

    aget-byte v3, v3, v4

    and-int/lit16 v3, v3, 0xff

    add-int/2addr v1, v3

    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    :cond_13
    add-int/lit8 v2, v2, 0x2

    new-array v3, v1, [B

    add-int v0, v1, v2

    if-eq v5, v0, :cond_14

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_1

    :cond_14
    const/4 v0, 0x0

    :goto_b
    array-length v1, v3

    if-ge v0, v1, :cond_15

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int v4, v2, v0

    aget-byte v1, v1, v4

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    aput-byte v1, v3, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    :cond_15
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/lang/String;-><init>([B)V

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x1b

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Lcn/jpush/android/util/a;->j(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_1

    :cond_16
    const/16 v0, 0x3ef

    if-ne v1, v0, :cond_19

    const/4 v1, 0x0

    const/4 v0, 0x0

    :goto_c
    const/4 v2, 0x2

    if-ge v0, v2, :cond_17

    shl-int/lit8 v1, v1, 0x8

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v3, v0, 0x16

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    add-int/2addr v1, v2

    add-int/lit8 v0, v0, 0x1

    goto :goto_c

    :cond_17
    new-array v1, v1, [B

    const/4 v0, 0x0

    :goto_d
    array-length v2, v1

    if-ge v0, v2, :cond_18

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v3, v0, 0x18

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_d

    :cond_18
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([B)V

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x27

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    invoke-static {v0}, Lcn/jpush/android/util/a;->c(Ljava/lang/String;)V

    if-nez p1, :cond_3

    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1, p3}, Lcn/jpush/android/service/PushService;->a(ZZZ)V

    goto/16 :goto_1

    :cond_19
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x8

    aget-object v0, v0, v2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x2b

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v1}, Lcn/jpush/android/service/p;->a(I)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1a

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x8

    aget-object v2, v2, v3

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x2d

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1a
    const/16 v0, 0x3ee

    if-ne v0, v1, :cond_1b

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->t()V

    goto/16 :goto_1

    :cond_1b
    const/16 v0, 0x3ef

    if-ne v0, v1, :cond_1c

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    goto/16 :goto_1

    :cond_1c
    const/16 v0, 0x3ed

    if-ne v0, v1, :cond_3

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x24

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x26

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/a;->f:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x1e

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x24

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x26

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/a;->f:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x1e

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcn/jpush/android/util/a;->c(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->t()V

    goto/16 :goto_1

    :cond_1d
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x8

    aget-object v1, v1, v2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x15

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcn/jpush/android/service/PushService;->ae:J

    goto/16 :goto_1

    :cond_1e
    move-object v0, v2

    goto/16 :goto_2
.end method

.method public static a()Z
    .locals 1

    sget-boolean v0, Lcn/jpush/android/service/PushService;->H:Z

    return v0
.end method

.method static synthetic a(Lcn/jpush/android/service/PushService;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcn/jpush/android/service/PushService;->ai:Z

    return p1
.end method

.method public static b()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/PushService;->I:Ljava/lang/String;

    return-object v0
.end method

.method public static b(Landroid/content/Context;)Ljava/lang/String;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/PushService;->t:Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcn/jpush/android/service/PushService;->t:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    invoke-static {p0}, Lcn/jpush/android/service/PushService;->c(Landroid/content/Context;)Z

    move-result v0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->V:Z

    sget-object v0, Lcn/jpush/android/service/PushService;->t:Ljava/lang/String;

    goto :goto_0
.end method

.method private static b([BI)Ljava/lang/String;
    .locals 5

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, p1, :cond_1

    aget-byte v0, p0, v1

    and-int/lit16 v0, v0, 0xff

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "0"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static b(I)V
    .locals 0

    sput p0, Lcn/jpush/android/service/PushService;->N:I

    return-void
.end method

.method static synthetic b(Lcn/jpush/android/service/PushService;)V
    .locals 0

    return-void
.end method

.method static synthetic b(Lcn/jpush/android/service/PushService;I)V
    .locals 1

    const/16 v0, 0x1770

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->g(I)V

    return-void
.end method

.method static synthetic b(Lcn/jpush/android/service/PushService;Z)V
    .locals 10

    const-wide/16 v8, 0x3e8

    const-wide/16 v6, 0x0

    :try_start_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->isAlive()Z

    move-result v0

    if-nez v0, :cond_4

    :cond_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    if-nez v0, :cond_2

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x9f

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v1}, Lcn/jpush/android/service/n;->getId()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    new-instance v0, Lcn/jpush/android/service/n;

    invoke-direct {v0, p0}, Lcn/jpush/android/service/n;-><init>(Lcn/jpush/android/service/PushService;)V

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    :goto_0
    invoke-static {}, Lcn/jpush/android/util/a;->b()V

    :goto_1
    return-void

    :cond_2
    :try_start_1
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->isAlive()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    iget-boolean v0, v0, Lcn/jpush/android/service/n;->a:Z

    if-nez v0, :cond_1

    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x9a

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v1}, Lcn/jpush/android/service/n;->getId()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->join()V

    new-instance v0, Lcn/jpush/android/service/n;

    invoke-direct {v0, p0}, Lcn/jpush/android/service/n;-><init>(Lcn/jpush/android/service/PushService;)V

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->start()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_2
    invoke-static {}, Lcn/jpush/android/util/x;->h()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    invoke-static {}, Lcn/jpush/android/util/a;->b()V

    goto :goto_1

    :cond_4
    if-nez p1, :cond_5

    :try_start_3
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcn/jpush/android/service/PushService;->ad:J

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->abs(J)J
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-wide v0

    const-wide/16 v2, 0x7530

    cmp-long v0, v0, v2

    if-gez v0, :cond_5

    invoke-static {}, Lcn/jpush/android/util/a;->b()V

    goto :goto_1

    :cond_5
    :try_start_4
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v1, Lcn/jpush/android/service/PushService;->s:J

    invoke-static {v0, v1, v2}, Lcn/jpush/android/service/PushProtocol;->HbJPush(IJ)I

    move-result v0

    if-eqz v0, :cond_6

    const/4 v0, 0x0

    iput v0, p0, Lcn/jpush/android/service/PushService;->ab:I

    iget v0, p0, Lcn/jpush/android/service/PushService;->af:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcn/jpush/android/service/PushService;->af:I

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    :cond_6
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3ef

    invoke-virtual {v0, v1}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3ef

    const-wide/16 v2, 0x2710

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    :cond_7
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcn/jpush/android/service/PushService;->ad:J

    iget v0, p0, Lcn/jpush/android/service/PushService;->ab:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcn/jpush/android/service/PushService;->ab:I

    const/4 v0, 0x0

    iput v0, p0, Lcn/jpush/android/service/PushService;->af:I

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sget-boolean v2, Lcn/jpush/android/service/PushService;->W:Z

    if-nez v2, :cond_a

    sget-boolean v2, Lcn/jpush/android/service/PushService;->Z:Z

    if-eqz v2, :cond_a

    sget-wide v2, Lcn/jpush/android/service/PushService;->j:J

    cmp-long v2, v2, v6

    if-nez v2, :cond_8

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x9c

    aget-object v3, v3, v4

    const-wide/16 v4, 0x0

    invoke-static {v2, v3, v4, v5}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;J)J

    move-result-wide v2

    sput-wide v2, Lcn/jpush/android/service/PushService;->j:J

    :cond_8
    sget-wide v2, Lcn/jpush/android/service/PushService;->j:J

    cmp-long v2, v2, v6

    if-eqz v2, :cond_9

    sget-wide v2, Lcn/jpush/android/service/PushService;->j:J

    sub-long v2, v0, v2

    sget-wide v4, Lcn/jpush/android/service/PushService;->e:J

    cmp-long v2, v2, v4

    if-gtz v2, :cond_9

    sget-wide v2, Lcn/jpush/android/service/PushService;->j:J

    cmp-long v2, v0, v2

    if-gez v2, :cond_a

    :cond_9
    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->D()V

    sput-wide v0, Lcn/jpush/android/service/PushService;->j:J

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x9c

    aget-object v3, v3, v4

    invoke-static {v2, v3, v0, v1}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;J)V

    :cond_a
    sget-wide v2, Lcn/jpush/android/service/PushService;->k:J

    cmp-long v2, v2, v6

    if-nez v2, :cond_b

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x99

    aget-object v3, v3, v4

    const-wide/16 v4, 0x0

    invoke-static {v2, v3, v4, v5}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;J)J

    move-result-wide v2

    sput-wide v2, Lcn/jpush/android/service/PushService;->k:J

    :cond_b
    invoke-static {}, Lcn/jpush/android/util/x;->a()Z

    sget-wide v2, Lcn/jpush/android/service/PushService;->k:J

    sub-long v2, v0, v2

    sget-wide v4, Lcn/jpush/android/service/PushService;->f:J

    cmp-long v2, v2, v4

    if-gtz v2, :cond_c

    sget-wide v2, Lcn/jpush/android/service/PushService;->k:J

    cmp-long v2, v0, v2

    if-gez v2, :cond_d

    :cond_c
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcn/jpush/android/util/j;->a(Landroid/content/Context;)V

    sput-wide v0, Lcn/jpush/android/service/PushService;->k:J

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x99

    aget-object v3, v3, v4

    invoke-static {v2, v3, v0, v1}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;J)V

    :cond_d
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcn/jpush/android/util/ag;->b(Landroid/content/Context;)J

    move-result-wide v2

    cmp-long v2, v6, v2

    if-nez v2, :cond_f

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-wide v1, Lcn/jpush/android/service/PushService;->m:J

    invoke-static {v0, v1, v2}, Lcn/jpush/android/util/ag;->a(Landroid/content/Context;J)V

    :cond_e
    :goto_2
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/service/g;->a(Landroid/content/Context;)Lcn/jpush/android/service/g;

    move-result-object v0

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/jpush/android/service/g;->d(Landroid/content/Context;)V

    invoke-static {}, Lcn/jpush/android/util/JLogger;->reportByHeartbeats()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/a;->b()V

    throw v0

    :cond_f
    :try_start_5
    invoke-static {}, Lcn/jpush/android/util/x;->a()Z

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcn/jpush/android/util/ag;->b(Landroid/content/Context;)J

    move-result-wide v2

    sub-long/2addr v0, v2

    sget-wide v2, Lcn/jpush/android/service/PushService;->E:J

    cmp-long v0, v0, v2

    if-lez v0, :cond_e

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    if-nez v0, :cond_10

    const-string v0, ""

    :goto_3
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ag;->a(Landroid/content/Context;)V

    goto :goto_2

    :cond_10
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x98

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v2, Ljava/text/SimpleDateFormat;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x9b

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    new-instance v3, Ljava/util/Date;

    invoke-static {v0}, Lcn/jpush/android/util/ag;->b(Landroid/content/Context;)J

    move-result-wide v4

    mul-long/2addr v4, v8

    invoke-direct {v3, v4, v5}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x9d

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    new-instance v1, Ljava/text/SimpleDateFormat;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x9b

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    new-instance v2, Ljava/util/Date;

    sget-wide v3, Lcn/jpush/android/service/PushService;->m:J

    mul-long/2addr v3, v8

    invoke-direct {v2, v3, v4}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x9e

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_3
.end method

.method public static b(Ljava/lang/String;)V
    .locals 0

    sput-object p0, Lcn/jpush/android/service/PushService;->J:Ljava/lang/String;

    return-void
.end method

.method private b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    const/16 v5, 0x11

    const/4 v4, 0x0

    :try_start_0
    invoke-static {p1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p2}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x12

    aget-object v0, v0, v1

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v0, v0, v5

    invoke-virtual {p0, v4, v0}, Lcn/jpush/android/service/PushService;->a(ILjava/lang/String;)V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->B()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->stopSelf()V

    :goto_0
    return-void

    :cond_1
    :try_start_1
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-nez v0, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-direct {p0, p1, p2}, Lcn/jpush/android/service/PushService;->c(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :goto_1
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v0, v0, v5

    invoke-virtual {p0, v4, v0}, Lcn/jpush/android/service/PushService;->a(ILjava/lang/String;)V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->B()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->stopSelf()V

    goto :goto_0

    :cond_2
    :try_start_2
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v1, Lcn/jpush/android/service/PushService;->s:J

    invoke-static {v0, v1, v2, p1, p2}, Lcn/jpush/android/service/PushProtocol;->UnChnelId(IJLjava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-gez v0, :cond_3

    invoke-direct {p0, p1, p2}, Lcn/jpush/android/service/PushService;->c(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    :catch_0
    move-exception v0

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v0, v0, v5

    invoke-virtual {p0, v4, v0}, Lcn/jpush/android/service/PushService;->a(ILjava/lang/String;)V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->B()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->stopSelf()V

    goto :goto_0

    :cond_3
    :try_start_3
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x13

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v1, v1, v5

    invoke-virtual {p0, v4, v1}, Lcn/jpush/android/service/PushService;->a(ILjava/lang/String;)V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->B()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->stopSelf()V

    throw v0
.end method

.method private declared-synchronized b(Ljava/lang/String;Ljava/lang/String;I)V
    .locals 4

    monitor-enter p0

    :try_start_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x1d

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x1d

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, p2}, Lcn/jpush/android/service/PushService;->e(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    const/16 v1, 0xc8

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static b(Z)V
    .locals 0

    sput-boolean p0, Lcn/jpush/android/service/PushService;->H:Z

    return-void
.end method

.method public static c(I)V
    .locals 0

    sput p0, Lcn/jpush/android/service/PushService;->O:I

    return-void
.end method

.method static synthetic c(Lcn/jpush/android/service/PushService;)V
    .locals 0

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->w()V

    return-void
.end method

.method public static c(Ljava/lang/String;)V
    .locals 0

    sput-object p0, Lcn/jpush/android/service/PushService;->L:Ljava/lang/String;

    return-void
.end method

.method private c(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v2, 0x7

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v1, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public static c(Z)V
    .locals 0

    sput-boolean p0, Lcn/jpush/android/service/PushService;->W:Z

    return-void
.end method

.method public static c()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method protected static declared-synchronized c(Landroid/content/Context;)Z
    .locals 12

    const-wide/16 v10, 0x0

    const/16 v9, 0x8

    const/4 v0, 0x0

    const-class v2, Lcn/jpush/android/service/PushService;

    monitor-enter v2

    :try_start_0
    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const/16 v1, 0x8

    :try_start_1
    new-array v3, v1, [B

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x25

    aget-object v1, v1, v4

    invoke-virtual {p0, v1}, Landroid/content/Context;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v4

    const/4 v1, 0x0

    const/16 v5, 0x8

    invoke-virtual {v4, v3, v1, v5}, Ljava/io/FileInputStream;->read([BII)I

    const-wide/16 v5, 0x0

    sput-wide v5, Lcn/jpush/android/service/PushService;->s:J

    move v1, v0

    :goto_0
    if-ge v1, v9, :cond_0

    sget-wide v5, Lcn/jpush/android/service/PushService;->s:J

    shl-long/2addr v5, v9

    aget-byte v7, v3, v1

    and-int/lit16 v7, v7, 0xff

    int-to-long v7, v7

    add-long/2addr v5, v7

    sput-wide v5, Lcn/jpush/android/service/PushService;->s:J

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    :goto_1
    invoke-virtual {v4}, Ljava/io/FileInputStream;->read()I

    move-result v3

    const/4 v5, -0x1

    if-eq v3, v5, :cond_1

    int-to-char v3, v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catch_0
    move-exception v1

    :try_start_2
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const-wide/16 v3, 0x0

    sput-wide v3, Lcn/jpush/android/service/PushService;->s:J

    :goto_2
    sget-wide v3, Lcn/jpush/android/service/PushService;->s:J
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    cmp-long v1, v3, v10

    if-nez v1, :cond_2

    :goto_3
    monitor-exit v2

    return v0

    :cond_1
    :try_start_3
    invoke-virtual {v4}, Ljava/io/FileInputStream;->close()V

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/jpush/android/service/PushService;->t:Ljava/lang/String;
    :try_end_3
    .catch Ljava/io/FileNotFoundException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2

    :catch_1
    move-exception v1

    :try_start_4
    invoke-static {}, Lcn/jpush/android/util/x;->h()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_2

    :catchall_0
    move-exception v0

    monitor-exit v2

    throw v0

    :cond_2
    :try_start_5
    sget-object v1, Lcn/jpush/android/service/PushService;->u:Ljava/lang/String;

    invoke-static {v1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-static {p0}, Lcn/jpush/android/util/a;->u(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/jpush/android/service/PushService;->u:Ljava/lang/String;

    :cond_3
    sget-object v1, Lcn/jpush/android/service/PushService;->u:Ljava/lang/String;

    invoke-static {v1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-static {}, Lcn/jpush/android/util/x;->c()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_3

    :cond_4
    const/4 v0, 0x1

    goto :goto_3
.end method

.method static synthetic c(Lcn/jpush/android/service/PushService;I)Z
    .locals 1

    invoke-direct {p0, p1}, Lcn/jpush/android/service/PushService;->j(I)Z

    move-result v0

    return v0
.end method

.method static synthetic d(Lcn/jpush/android/service/PushService;)Lcn/jpush/android/service/n;
    .locals 1

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    return-object v0
.end method

.method public static d(I)V
    .locals 0

    sput p0, Lcn/jpush/android/service/PushService;->X:I

    return-void
.end method

.method public static d(Ljava/lang/String;)V
    .locals 0

    sput-object p0, Lcn/jpush/android/service/PushService;->M:Ljava/lang/String;

    return-void
.end method

.method private d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xd5

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v1, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public static d(Z)V
    .locals 0

    sput-boolean p0, Lcn/jpush/android/service/PushService;->Z:Z

    return-void
.end method

.method static synthetic e(Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    sput-object p0, Lcn/jpush/android/service/PushService;->I:Ljava/lang/String;

    return-object p0
.end method

.method static synthetic e(Lcn/jpush/android/service/PushService;)V
    .locals 0

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->D()V

    return-void
.end method

.method private e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 7

    const/4 v6, 0x2

    invoke-static {p1}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p2}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    :try_start_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v3, 0x6

    aget-object v2, v2, v3

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    array-length v3, v2

    if-le v3, v6, :cond_3

    const/4 v3, 0x0

    aget-object v3, v2, v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    const/4 v4, 0x1

    aget-object v4, v2, v4

    const/4 v5, 0x2

    aget-object v2, v2, v5

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-virtual {p2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v2, v0}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z

    invoke-direct {p0, v3}, Lcn/jpush/android/service/PushService;->i(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto :goto_0

    :cond_3
    :try_start_1
    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v4, 0x5

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v2, v0}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method static synthetic e(Z)Z
    .locals 0

    sput-boolean p0, Lcn/jpush/android/service/PushService;->V:Z

    return p0
.end method

.method static synthetic f(Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    sput-object p0, Lcn/jpush/android/service/PushService;->ak:Ljava/lang/String;

    return-object p0
.end method

.method private static f(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 5

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xac

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xac

    aget-object v2, v2, v3

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xac

    aget-object v3, v3, v4

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_0
    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xad

    aget-object v2, v2, v3

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xad

    aget-object v2, v2, v3

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xad

    aget-object v3, v3, v4

    invoke-virtual {v1, v3}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_1
    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic f(Lcn/jpush/android/service/PushService;)V
    .locals 0

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->w()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    return-void
.end method

.method static synthetic g(Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    sput-object p0, Lcn/jpush/android/service/PushService;->al:Ljava/lang/String;

    return-object p0
.end method

.method private g(I)V
    .locals 4

    const/16 v3, 0x3ec

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x8a

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x8b

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3ed

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    int-to-long v1, p1

    invoke-virtual {v0, v3, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    return-void
.end method

.method private g(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x96

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    return-void
.end method

.method static synthetic h()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/PushService;->J:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic h(Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    sput-object p0, Lcn/jpush/android/service/PushService;->am:Ljava/lang/String;

    return-object p0
.end method

.method private h(I)V
    .locals 4

    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    const/16 v1, 0x3f0

    iput v1, v0, Landroid/os/Message;->what:I

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const-wide/16 v2, 0x2710

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    return-void
.end method

.method static synthetic i()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/PushService;->I:Ljava/lang/String;

    return-object v0
.end method

.method private i(I)V
    .locals 3

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3f0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Handler;->removeMessages(ILjava/lang/Object;)V

    return-void
.end method

.method private i(Ljava/lang/String;)V
    .locals 8

    const/4 v7, 0x1

    const/4 v1, 0x0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    move v0, v1

    move v4, v1

    :goto_0
    const/4 v2, 0x2

    if-ge v0, v2, :cond_0

    shl-int/lit8 v2, v4, 0x8

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v4, v0, 0x14

    aget-byte v3, v3, v4

    and-int/lit16 v3, v3, 0xff

    add-int/2addr v2, v3

    add-int/lit8 v0, v0, 0x1

    move v4, v2

    goto :goto_0

    :cond_0
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x6a

    aget-object v0, v0, v2

    new-array v2, v7, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v1

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const-wide/16 v2, 0x0

    move v0, v1

    :goto_1
    const/4 v5, 0x4

    if-ge v0, v5, :cond_1

    const/16 v5, 0x8

    shl-long/2addr v2, v5

    iget-object v5, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v6, v0, 0x16

    aget-byte v5, v5, v6

    and-int/lit16 v5, v5, 0xff

    int-to-long v5, v5

    add-long/2addr v2, v5

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x68

    aget-object v0, v0, v5

    new-array v5, v7, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v5, v1

    invoke-static {v0, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/16 v0, 0x64

    new-array v2, v0, [B

    move v0, v1

    :goto_2
    array-length v3, v2

    if-ge v0, v3, :cond_2

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v5, v0, 0x1a

    aget-byte v3, v3, v5

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v5, v0, 0x1a

    aget-byte v3, v3, v5

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    aput-byte v3, v2, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    :cond_2
    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v2, v1, v0}, Ljava/lang/String;-><init>([BII)V

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x67

    aget-object v2, v2, v5

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/16 v0, 0x1e

    new-array v2, v0, [B

    move v0, v1

    :goto_3
    array-length v5, v2

    if-ge v0, v5, :cond_3

    iget-object v5, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v6, v0, 0x7e

    aget-byte v5, v5, v6

    if-eqz v5, :cond_3

    iget-object v5, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v6, v0, 0x7e

    aget-byte v5, v5, v6

    and-int/lit16 v5, v5, 0xff

    int-to-byte v5, v5

    aput-byte v5, v2, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_3
    new-instance v5, Ljava/lang/String;

    invoke-direct {v5, v2, v1, v0}, Ljava/lang/String;-><init>([BII)V

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x69

    aget-object v2, v2, v6

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-nez v4, :cond_4

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v2, v2, v7

    invoke-virtual {v0, v2, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    invoke-virtual {v0, v3}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xb1

    aget-object v2, v2, v4

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v3, v4, v1

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcn/jpush/android/service/PushService;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    :cond_4
    return-void
.end method

.method static synthetic j()I
    .locals 1

    sget v0, Lcn/jpush/android/service/PushService;->K:I

    return v0
.end method

.method private j(Ljava/lang/String;)V
    .locals 7

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xd6

    aget-object v1, v1, v2

    sget v2, Lcn/jpush/android/api/d;->i:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v1

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xd9

    aget-object v2, v2, v3

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {v0}, Lcn/jpush/android/service/ServiceInterface;->a(I)Lcn/jpush/android/api/b;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v3, v2, Lcn/jpush/android/api/b;->c:Lcn/jpush/android/api/TagAliasCallback;

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xd8

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-eqz v3, :cond_1

    invoke-static {v0}, Lcn/jpush/android/service/ServiceInterface;->b(I)V

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->k(I)V

    iget-object v4, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v5, 0x3ee

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v4, v5, v0}, Landroid/os/Handler;->removeMessages(ILjava/lang/Object;)V

    iget-object v0, v2, Lcn/jpush/android/api/b;->a:Ljava/lang/String;

    iget-object v2, v2, Lcn/jpush/android/api/b;->b:Ljava/util/Set;

    invoke-interface {v3, v1, v0, v2}, Lcn/jpush/android/api/TagAliasCallback;->gotResult(ILjava/lang/String;Ljava/util/Set;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xd7

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private j(I)Z
    .locals 5

    const/4 v1, 0x0

    :try_start_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v4, 0x6

    aget-object v3, v3, v4

    invoke-virtual {v0, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    array-length v3, v0

    const/4 v4, 0x2

    if-le v3, v4, :cond_0

    const/4 v3, 0x0

    aget-object v0, v0, v3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    if-ne p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method private declared-synchronized k(I)V
    .locals 5

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v3, 0x6

    aget-object v2, v2, v3

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    array-length v3, v2

    const/4 v4, 0x2

    if-lt v3, v4, :cond_2

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v3, v0}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z

    invoke-direct {p0, v2}, Lcn/jpush/android/service/PushService;->i(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v2, p1, :cond_0

    :cond_1
    :goto_1
    monitor-exit p0

    return-void

    :cond_2
    :try_start_1
    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v4, 0x5

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v2, v0}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_2
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private k(Ljava/lang/String;)V
    .locals 6

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Lorg/json/JSONObject;)V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xc

    aget-object v0, v0, v1

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xa

    aget-object v1, v1, v2

    invoke-static {p0, v0, v1}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xb

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v1, Lcn/jpush/android/service/PushService;->s:J

    const/4 v3, 0x3

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xd

    aget-object v4, v4, v5

    invoke-static {v0, v1, v2, v3, v4}, Lcn/jpush/android/service/PushProtocol;->RepPush(IJBLjava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto :goto_0
.end method

.method static synthetic k()Z
    .locals 1

    sget-boolean v0, Lcn/jpush/android/service/PushService;->V:Z

    return v0
.end method

.method private l(Ljava/lang/String;)V
    .locals 9

    const/4 v8, 0x1

    const/4 v7, -0x1

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xa3

    aget-object v0, v0, v2

    const/4 v2, -0x1

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v2

    if-eq v2, v7, :cond_6

    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa4

    aget-object v0, v0, v4

    const/4 v4, -0x1

    invoke-virtual {v1, v0, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    if-eq v0, v7, :cond_0

    if-nez v0, :cond_7

    const/4 v0, 0x1

    sput-boolean v0, Lcn/jpush/android/service/PushService;->Z:Z

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa4

    aget-object v0, v0, v4

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    :goto_0
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa2

    aget-object v0, v0, v4

    const/4 v4, -0x1

    invoke-virtual {v1, v0, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xa1

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-eq v0, v7, :cond_1

    if-nez v0, :cond_8

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa2

    aget-object v0, v0, v4

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_1
    :goto_1
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa7

    aget-object v0, v0, v4

    const/4 v4, -0x1

    invoke-virtual {v1, v0, v4}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    if-eq v0, v7, :cond_2

    if-nez v0, :cond_9

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa7

    aget-object v0, v0, v4

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    :goto_2
    invoke-virtual {v3}, Ljava/util/HashMap;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/4 v0, 0x2

    if-ne v2, v0, :cond_d

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xaa

    aget-object v0, v0, v2

    const/4 v2, -0x1

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v1

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xa8

    aget-object v0, v0, v2

    if-eq v1, v7, :cond_3

    if-nez v1, :cond_a

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xa8

    aget-object v0, v0, v1

    :cond_3
    :goto_3
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcn/jpush/android/service/PushService;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xaa

    aget-object v4, v4, v5

    invoke-virtual {v2, v4, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa2

    aget-object v0, v0, v4

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_4

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa2

    aget-object v4, v0, v4

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xa2

    aget-object v0, v0, v5

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {v2, v4, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    :cond_4
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa7

    aget-object v0, v0, v4

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_5

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa7

    aget-object v4, v0, v4

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xa7

    aget-object v0, v0, v5

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {v2, v4, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    :cond_5
    invoke-virtual {v1, v2}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    invoke-virtual {p0, v1}, Lcn/jpush/android/service/PushService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    :cond_6
    :goto_4
    return-void

    :cond_7
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa4

    aget-object v0, v0, v4

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto :goto_4

    :cond_8
    :try_start_1
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa2

    aget-object v0, v0, v4

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_1

    :cond_9
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa7

    aget-object v0, v0, v4

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v3, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_2

    :cond_a
    if-ne v1, v8, :cond_b

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xa6

    aget-object v0, v0, v1

    goto/16 :goto_3

    :cond_b
    const/4 v2, 0x2

    if-ne v1, v2, :cond_c

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xa5

    aget-object v0, v0, v1

    goto/16 :goto_3

    :cond_c
    const/4 v2, 0x3

    if-ne v1, v2, :cond_3

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xa9

    aget-object v0, v0, v1

    goto/16 :goto_3

    :cond_d
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa7

    aget-object v0, v0, v4

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_e

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa7

    aget-object v0, v0, v4

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->B:Z

    :cond_e
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa2

    aget-object v0, v0, v4

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_f

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa2

    aget-object v0, v0, v4

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->C:Z

    :cond_f
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa4

    aget-object v0, v0, v4

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_10

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa4

    aget-object v0, v0, v4

    invoke-interface {v3, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->Z:Z

    :cond_10
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xaa

    aget-object v0, v0, v3

    const/4 v3, -0x1

    invoke-virtual {v1, v0, v3}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    if-eq v0, v7, :cond_11

    if-nez v0, :cond_12

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xa8

    aget-object v0, v0, v1

    sput-object v0, Lcn/jpush/android/service/PushService;->A:Ljava/lang/String;

    :cond_11
    :goto_5
    if-nez v2, :cond_6

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcn/jpush/android/service/PushService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x91

    aget-object v2, v2, v3

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x91

    aget-object v3, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    invoke-virtual {p0, v0}, Lcn/jpush/android/service/PushService;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto/16 :goto_4

    :cond_12
    if-ne v0, v8, :cond_13

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xa6

    aget-object v0, v0, v1

    sput-object v0, Lcn/jpush/android/service/PushService;->A:Ljava/lang/String;

    goto :goto_5

    :cond_13
    const/4 v1, 0x2

    if-ne v0, v1, :cond_14

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xa5

    aget-object v0, v0, v1

    sput-object v0, Lcn/jpush/android/service/PushService;->A:Ljava/lang/String;

    goto :goto_5

    :cond_14
    const/4 v1, 0x3

    if-ne v0, v1, :cond_11

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0xa9

    aget-object v0, v0, v1

    sput-object v0, Lcn/jpush/android/service/PushService;->A:Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_5
.end method

.method static synthetic l()Z
    .locals 1

    sget-boolean v0, Lcn/jpush/android/service/PushService;->W:Z

    return v0
.end method

.method static synthetic m()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/PushService;->am:Ljava/lang/String;

    return-object v0
.end method

.method private m(Ljava/lang/String;)V
    .locals 11

    const/4 v10, 0x2

    const/4 v0, 0x0

    :try_start_0
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    move v1, v0

    move v3, v0

    :goto_0
    if-ge v1, v10, :cond_0

    shl-int/lit8 v2, v3, 0x8

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v4, v1, 0x14

    aget-byte v3, v3, v4

    and-int/lit16 v3, v3, 0xff

    add-int/2addr v2, v3

    add-int/lit8 v1, v1, 0x1

    move v3, v2

    goto :goto_0

    :cond_0
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x6a

    aget-object v1, v1, v2

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/16 v1, 0x8

    new-array v2, v1, [B

    move v1, v0

    :goto_1
    array-length v4, v2

    if-ge v1, v4, :cond_1

    iget-object v4, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v5, v1, 0x16

    aget-byte v4, v4, v5

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    new-instance v4, Ljava/lang/StringBuilder;

    array-length v1, v2

    mul-int/lit8 v1, v1, 0x2

    invoke-direct {v4, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    array-length v5, v2

    move v1, v0

    :goto_2
    if-ge v1, v5, :cond_2

    aget-byte v6, v2, v1

    sget-object v7, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v8, 0x6c

    aget-object v7, v7, v8

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    and-int/lit16 v6, v6, 0xff

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_2
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x6b

    aget-object v2, v2, v5

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    move v1, v0

    move v2, v0

    :goto_3
    if-ge v1, v10, :cond_3

    shl-int/lit8 v2, v2, 0x8

    iget-object v5, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v6, v1, 0x1e

    aget-byte v5, v5, v6

    and-int/lit16 v5, v5, 0xff

    add-int/2addr v2, v5

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xae

    aget-object v5, v5, v6

    invoke-direct {v1, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/16 v1, 0x64

    new-array v1, v1, [B

    :goto_4
    array-length v2, v1

    if-ge v0, v2, :cond_4

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v5, v0, 0x20

    aget-byte v2, v2, v5

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v5, v0, 0x20

    aget-byte v2, v2, v5

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    :cond_4
    new-instance v2, Ljava/lang/String;

    const/4 v5, 0x0

    invoke-direct {v2, v1, v5, v0}, Ljava/lang/String;-><init>([BII)V

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x67

    aget-object v1, v1, v5

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-nez v3, :cond_5

    const/4 v0, 0x0

    invoke-direct {p0, v2, v0, v4, p1}, Lcn/jpush/android/service/PushService;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :goto_5
    return-void

    :cond_5
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x6d

    aget-object v0, v0, v1

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_5

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    goto :goto_5
.end method

.method static synthetic n()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/PushService;->al:Ljava/lang/String;

    return-object v0
.end method

.method private n(Ljava/lang/String;)V
    .locals 12

    const/16 v7, 0x8

    const/4 v0, 0x0

    :try_start_0
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    move v1, v0

    move v4, v0

    :goto_0
    const/4 v2, 0x2

    if-ge v1, v2, :cond_0

    shl-int/lit8 v2, v4, 0x8

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v4, v1, 0x14

    aget-byte v3, v3, v4

    and-int/lit16 v3, v3, 0xff

    add-int/2addr v2, v3

    add-int/lit8 v1, v1, 0x1

    move v4, v2

    goto :goto_0

    :cond_0
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x6a

    aget-object v1, v1, v2

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const-wide/16 v1, 0x0

    move-wide v10, v1

    move-wide v2, v10

    move v1, v0

    :goto_1
    const/4 v5, 0x4

    if-ge v1, v5, :cond_1

    shl-long/2addr v2, v7

    iget-object v5, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v6, v1, 0x16

    aget-byte v5, v5, v6

    and-int/lit16 v5, v5, 0xff

    int-to-long v5, v5

    add-long/2addr v2, v5

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x68

    aget-object v1, v1, v5

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    aput-object v2, v5, v6

    invoke-static {v1, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/16 v1, 0x8

    new-array v2, v1, [B

    move v1, v0

    :goto_2
    array-length v3, v2

    if-ge v1, v3, :cond_2

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v5, v1, 0x1a

    aget-byte v3, v3, v5

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    aput-byte v3, v2, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    array-length v1, v2

    mul-int/lit8 v1, v1, 0x2

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    array-length v5, v2

    move v1, v0

    :goto_3
    if-ge v1, v5, :cond_3

    aget-byte v6, v2, v1

    sget-object v7, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v8, 0x6c

    aget-object v7, v7, v8

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    and-int/lit16 v6, v6, 0xff

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_3
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x6b

    aget-object v3, v3, v5

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/16 v1, 0x64

    new-array v3, v1, [B

    move v1, v0

    :goto_4
    array-length v5, v3

    if-ge v1, v5, :cond_4

    iget-object v5, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v6, v1, 0x22

    aget-byte v5, v5, v6

    if-eqz v5, :cond_4

    iget-object v5, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v6, v1, 0x22

    aget-byte v5, v5, v6

    and-int/lit16 v5, v5, 0xff

    int-to-byte v5, v5

    aput-byte v5, v3, v1

    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    :cond_4
    new-instance v5, Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {v5, v3, v6, v1}, Ljava/lang/String;-><init>([BII)V

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x67

    aget-object v3, v3, v6

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/16 v1, 0x1e

    new-array v1, v1, [B

    :goto_5
    array-length v3, v1

    if-ge v0, v3, :cond_5

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit16 v6, v0, 0x86

    aget-byte v3, v3, v6

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit16 v6, v0, 0x86

    aget-byte v3, v3, v6

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    aput-byte v3, v1, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    :cond_5
    new-instance v3, Ljava/lang/String;

    const/4 v6, 0x0

    invoke-direct {v3, v1, v6, v0}, Ljava/lang/String;-><init>([BII)V

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x69

    aget-object v1, v1, v6

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-nez v4, :cond_6

    invoke-direct {p0, v5, v3, v2, p1}, Lcn/jpush/android/service/PushService;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :goto_6
    return-void

    :cond_6
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x6d

    aget-object v0, v0, v1

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_6

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    goto :goto_6
.end method

.method static synthetic o()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcn/jpush/android/service/PushService;->ak:Ljava/lang/String;

    return-object v0
.end method

.method private o(Ljava/lang/String;)V
    .locals 7

    const/4 v6, 0x1

    const/4 v5, -0x1

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x91

    aget-object v1, v1, v2

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v1

    if-eq v1, v5, :cond_0

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x95

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    mul-int/lit8 v1, v1, 0x3c

    sput v1, Lcn/jpush/android/service/PushService;->i:I

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x2e

    aget-object v1, v1, v2

    sget v2, Lcn/jpush/android/service/PushService;->i:I

    invoke-static {p0, v1, v2}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V

    :cond_0
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x8f

    aget-object v1, v1, v2

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v1

    if-eq v1, v5, :cond_1

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x8c

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-nez v1, :cond_5

    const/4 v1, 0x0

    sput-boolean v1, Lcn/jpush/android/service/PushService;->q:Z

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x92

    aget-object v1, v1, v2

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x73

    aget-object v2, v2, v3

    invoke-static {p0, v1, v2}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    :goto_0
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x90

    aget-object v1, v1, v2

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v1

    if-eq v1, v5, :cond_2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x94

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-nez v1, :cond_6

    const/4 v2, 0x0

    sput-boolean v2, Lcn/jpush/android/service/PushService;->r:Z

    :goto_1
    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x90

    aget-object v2, v2, v3

    invoke-static {p0, v2, v1}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V

    :cond_2
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x93

    aget-object v1, v1, v2

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v1

    if-eq v1, v5, :cond_3

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x8e

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x93

    aget-object v2, v2, v3

    invoke-static {p0, v2, v1}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V

    :cond_3
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x8d

    aget-object v1, v1, v2

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;I)I

    move-result v0

    if-eq v0, v5, :cond_4

    if-nez v0, :cond_7

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x72

    aget-object v0, v0, v1

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x73

    aget-object v1, v1, v2

    invoke-static {p0, v0, v1}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->stopSelf()V

    :cond_4
    :goto_2
    return-void

    :cond_5
    const/4 v1, 0x1

    sput-boolean v1, Lcn/jpush/android/service/PushService;->q:Z

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x92

    aget-object v1, v1, v2

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xb

    aget-object v2, v2, v3

    invoke-static {p0, v1, v2}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto :goto_2

    :cond_6
    const/4 v2, 0x1

    :try_start_1
    sput-boolean v2, Lcn/jpush/android/service/PushService;->r:Z

    goto :goto_1

    :cond_7
    if-ne v0, v6, :cond_8

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->stopSelf()V

    goto :goto_2

    :cond_8
    const/4 v1, 0x2

    if-ne v0, v1, :cond_4

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/service/ServiceInterface;->d(Landroid/content/Context;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method

.method static synthetic p()Z
    .locals 1

    sget-boolean v0, Lcn/jpush/android/service/PushService;->Z:Z

    return v0
.end method

.method private q()V
    .locals 4

    const/16 v3, 0x3e9

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x97

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v1, Lcn/jpush/android/service/PushService;->X:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "s"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    sget v1, Lcn/jpush/android/service/PushService;->X:I

    mul-int/lit16 v1, v1, 0x3e8

    int-to-long v1, v1

    invoke-virtual {v0, v3, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    return-void
.end method

.method private r()[B
    .locals 7

    const/4 v6, 0x2

    const/4 v1, 0x0

    invoke-static {p0}, Lcn/jpush/android/util/a;->d(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x2c

    aget-object v0, v0, v3

    invoke-virtual {p0, v0}, Lcn/jpush/android/service/PushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getNetworkOperator()Ljava/lang/String;

    move-result-object v0

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x54

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :try_start_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :goto_0
    const/16 v3, 0x80

    new-array v3, v3, [B

    new-array v4, v6, [B

    fill-array-data v4, :array_0

    array-length v5, v4

    invoke-static {v4, v1, v3, v1, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    invoke-static {v3, v2, v6}, Lcn/jpush/android/util/aa;->a([BLjava/lang/String;I)[B

    const/16 v2, 0x22

    invoke-static {v3, v0, v2}, Lcn/jpush/android/util/aa;->e([BII)[B

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-wide v4, Lcn/jpush/android/service/PushService;->s:J

    invoke-virtual {v0, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/16 v2, 0x26

    invoke-static {v3, v0, v2}, Lcn/jpush/android/util/aa;->e([BII)[B

    sget-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v2, 0x32

    if-le v0, v2, :cond_0

    sget-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    const/16 v2, 0x31

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    :cond_0
    sget-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    const/16 v2, 0x2a

    invoke-static {v3, v0, v2}, Lcn/jpush/android/util/aa;->a([BLjava/lang/String;I)[B

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x17

    aget-object v0, v0, v2

    const/16 v2, 0x5c

    invoke-static {v3, v0, v2}, Lcn/jpush/android/util/aa;->a([BLjava/lang/String;I)[B

    sget-boolean v0, Lcn/jpush/android/service/PushService;->c:Z

    if-eqz v0, :cond_1

    const/4 v1, 0x1

    :cond_1
    const/16 v0, 0x66

    invoke-static {v3, v1, v0}, Lcn/jpush/android/util/aa;->e([BII)[B

    return-object v3

    :catch_0
    move-exception v0

    move v0, v1

    goto :goto_0

    :array_0
    .array-data 1
        0x0t
        0x50t
    .end array-data
.end method

.method private declared-synchronized s()V
    .locals 2

    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcn/jpush/android/util/x;->c()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x25

    aget-object v0, v0, v1

    invoke-virtual {p0, v0}, Lcn/jpush/android/service/PushService;->deleteFile(Ljava/lang/String;)Z

    const/4 v0, 0x0

    sput-boolean v0, Lcn/jpush/android/service/PushService;->V:Z

    const-wide/16 v0, 0x0

    sput-wide v0, Lcn/jpush/android/service/PushService;->s:J
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :goto_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private t()V
    .locals 4

    const v3, 0x15181

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x2e

    aget-object v1, v1, v2

    invoke-static {v0, v1, v3}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V

    sput v3, Lcn/jpush/android/service/PushService;->i:I

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->stopSelf()V

    return-void
.end method

.method private u()Ljava/lang/String;
    .locals 4

    const/16 v3, 0x1e

    :try_start_0
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-le v1, v3, :cond_0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x8

    aget-object v1, v1, v2

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x66

    aget-object v2, v2, v3

    invoke-static {v1, v2}, Lcn/jpush/android/util/x;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    const/16 v2, 0x1e

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :cond_0
    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x65

    aget-object v0, v0, v1

    goto :goto_0
.end method

.method private v()V
    .locals 5

    const/4 v4, 0x2

    const/4 v0, 0x0

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->w:[B

    array-length v1, v1

    const/16 v2, 0x1f

    if-ge v1, v2, :cond_0

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    :goto_0
    return-void

    :cond_0
    iget-object v1, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/16 v2, 0x14

    aget-byte v1, v1, v2

    invoke-static {v1}, Lcn/jpush/android/util/a;->a(B)I

    move-result v2

    move v1, v0

    :goto_1
    const/16 v3, 0x8

    if-ge v1, v3, :cond_1

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_1
    if-ne v2, v4, :cond_2

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x53

    aget-object v1, v1, v2

    sget-wide v2, Lcn/jpush/android/service/PushService;->m:J

    invoke-static {v0, v1, v2, v3}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;J)J

    move-result-wide v0

    sput-wide v0, Lcn/jpush/android/service/PushService;->m:J

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x4f

    aget-object v1, v1, v2

    sget-wide v2, Lcn/jpush/android/service/PushService;->n:J

    invoke-static {v0, v1, v2, v3}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;J)J

    move-result-wide v0

    sput-wide v0, Lcn/jpush/android/service/PushService;->n:J

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x50

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-wide v1, Lcn/jpush/android/service/PushService;->m:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x52

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-wide v1, Lcn/jpush/android/service/PushService;->n:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->C()V

    goto :goto_0

    :cond_2
    const/16 v1, 0xa

    if-ne v2, v1, :cond_4

    move v1, v0

    :goto_2
    if-ge v1, v4, :cond_3

    shl-int/lit8 v0, v0, 0x8

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    add-int/lit8 v3, v1, 0x4

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    add-int/2addr v0, v2

    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x51

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->i(I)V

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->k(I)V

    goto/16 :goto_0

    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x48

    aget-object v1, v1, v3

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    goto/16 :goto_0
.end method

.method private declared-synchronized w()V
    .locals 1

    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_0

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    invoke-static {v0}, Lcn/jpush/android/service/PushProtocol;->Stop(I)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized x()V
    .locals 8

    const/4 v7, 0x2

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3f0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_0
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xab

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v2, 0x6

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    array-length v2, v1

    if-le v2, v7, :cond_2

    const/4 v0, 0x0

    aget-object v0, v1, v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    const/4 v0, 0x1

    aget-object v3, v1, v0

    const/4 v0, 0x2

    aget-object v4, v1, v0

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v1, Lcn/jpush/android/service/PushService;->s:J

    invoke-static/range {v0 .. v5}, Lcn/jpush/android/service/PushService;->a(IJLjava/lang/String;Ljava/lang/String;I)I

    invoke-direct {p0, v5}, Lcn/jpush/android/service/PushService;->h(I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_2
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_1
    monitor-exit p0

    return-void

    :cond_2
    :try_start_3
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v3, 0x5

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->y:Ljava/util/Queue;

    invoke-interface {v1, v0}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private y()V
    .locals 3

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->C()V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->isAlive()Z

    move-result v0

    if-nez v0, :cond_1

    :try_start_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->join()V

    new-instance v0, Lcn/jpush/android/service/n;

    invoke-direct {v0, p0}, Lcn/jpush/android/service/n;-><init>(Lcn/jpush/android/service/PushService;)V

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto :goto_0

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xa0

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v1}, Lcn/jpush/android/service/n;->getId()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :try_start_1
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    iget-boolean v0, v0, Lcn/jpush/android/service/n;->a:Z

    if-nez v0, :cond_0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    new-instance v0, Lcn/jpush/android/service/n;

    invoke-direct {v0, p0}, Lcn/jpush/android/service/n;-><init>(Lcn/jpush/android/service/PushService;)V

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->start()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    :catch_1
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto :goto_0

    :cond_2
    :try_start_2
    new-instance v0, Lcn/jpush/android/service/n;

    invoke-direct {v0, p0}, Lcn/jpush/android/service/n;-><init>(Lcn/jpush/android/service/PushService;)V

    iput-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->start()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_0

    :catch_2
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->h()V

    goto :goto_0
.end method

.method private z()V
    .locals 2

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    :goto_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v0}, Lcn/jpush/android/data/r;->a(Landroid/content/Context;Ljava/lang/String;)Z

    goto :goto_0

    :cond_0
    return-void
.end method


# virtual methods
.method protected final a(ILjava/lang/String;)V
    .locals 7

    const/4 v2, 0x0

    const/4 v1, 0x1

    sget-object v3, Lcn/jpush/android/a;->b:Ljava/lang/String;

    sget-object v0, Lcn/jpush/android/a;->f:Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget v4, p0, Lcn/jpush/android/service/PushService;->ag:I

    if-ne p1, v4, :cond_0

    :goto_0
    return-void

    :cond_0
    iput p1, p0, Lcn/jpush/android/service/PushService;->ag:I

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xb3

    aget-object v5, v5, v6

    invoke-static {v4, v5, p1}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V

    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4, p2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    if-eqz v0, :cond_1

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v5, v5, v1

    invoke-virtual {v4, v5, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    :cond_1
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xb2

    aget-object v5, v0, v5

    if-ne p1, v1, :cond_2

    move v0, v1

    :goto_1
    invoke-virtual {v4, v5, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    invoke-static {v3}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getPackageName()Ljava/lang/String;

    move-result-object v0

    :goto_2
    invoke-virtual {v4, v0}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xb1

    aget-object v3, v3, v5

    new-array v1, v1, [Ljava/lang/Object;

    aput-object v0, v1, v2

    invoke-static {v3, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v4, v0}, Lcn/jpush/android/service/PushService;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    move v0, v2

    goto :goto_1

    :cond_3
    move-object v0, v3

    goto :goto_2
.end method

.method public final d()V
    .locals 11

    const/4 v9, 0x2

    const/16 v8, 0x50

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcn/jpush/android/service/PushService;->ae:J

    sub-long/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->abs(J)J

    move-result-wide v0

    const-wide/32 v2, 0x927c0

    cmp-long v0, v0, v2

    if-gez v0, :cond_1

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    :cond_0
    :goto_0
    return-void

    :cond_1
    const/4 v0, 0x0

    :try_start_0
    new-instance v1, Ljava/net/DatagramSocket;

    invoke-direct {v1}, Ljava/net/DatagramSocket;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    const/16 v0, 0x400

    :try_start_1
    new-array v4, v0, [B

    sget-object v0, Lcn/jpush/android/service/PushService;->aa:Ljava/util/List;

    sget v2, Lcn/jpush/android/service/PushService;->D:I

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-eqz v0, :cond_2

    const-string v2, "$"

    invoke-virtual {v0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-lez v2, :cond_2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x57

    aget-object v3, v3, v5

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x5b

    aget-object v2, v2, v3

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    const/4 v2, 0x0

    aget-object v2, v0, v2

    sput-object v2, Lcn/jpush/android/service/PushService;->L:Ljava/lang/String;

    const/4 v2, 0x1

    aget-object v0, v0, v2

    sput-object v0, Lcn/jpush/android/service/PushService;->M:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_2
    :try_start_2
    sget-object v0, Lcn/jpush/android/service/PushService;->L:Ljava/lang/String;

    invoke-static {v0}, Ljava/net/InetAddress;->getAllByName(Ljava/lang/String;)[Ljava/net/InetAddress;

    move-result-object v0

    const/4 v2, 0x0

    aget-object v0, v0, v2
    :try_end_2
    .catch Ljava/net/UnknownHostException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-object v3, v0

    :goto_1
    :try_start_3
    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->r()[B

    move-result-object v5

    array-length v0, v5

    const/16 v2, 0x100

    if-le v0, v2, :cond_d

    const/16 v0, 0x100

    move v2, v0

    :goto_2
    sget v0, Lcn/jpush/android/service/PushService;->N:I

    if-ne v0, v8, :cond_4

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v6, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0x56

    aget-object v6, v6, v7

    invoke-direct {v0, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v6, Lcn/jpush/android/service/PushService;->N:I

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    new-instance v0, Ljava/net/DatagramPacket;

    sget v6, Lcn/jpush/android/service/PushService;->N:I

    invoke-direct {v0, v5, v2, v3, v6}, Ljava/net/DatagramPacket;-><init>([BILjava/net/InetAddress;I)V

    :goto_3
    const/16 v2, 0xbb8

    invoke-virtual {v1, v2}, Ljava/net/DatagramSocket;->setSoTimeout(I)V

    invoke-virtual {v1, v0}, Ljava/net/DatagramSocket;->send(Ljava/net/DatagramPacket;)V

    new-instance v0, Ljava/net/DatagramPacket;

    array-length v2, v4

    invoke-direct {v0, v4, v2}, Ljava/net/DatagramPacket;-><init>([BI)V

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {v1, v0}, Ljava/net/DatagramSocket;->receive(Ljava/net/DatagramPacket;)V

    invoke-virtual {v0}, Ljava/net/DatagramPacket;->getLength()I

    move-result v2

    new-array v2, v2, [B

    invoke-virtual {v0}, Ljava/net/DatagramPacket;->getData()[B

    move-result-object v0

    const/4 v3, 0x0

    const/4 v4, 0x0

    array-length v5, v2

    invoke-static {v0, v3, v2, v4, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>([B)V

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x5e

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    const/4 v2, 0x0

    sput-object v2, Lcn/jpush/android/service/PushService;->J:Ljava/lang/String;

    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x55

    aget-object v0, v0, v3

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result v2

    if-nez v2, :cond_6

    :cond_3
    :goto_4
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/net/DatagramSocket;->close()V

    goto/16 :goto_0

    :catch_0
    move-exception v0

    :try_start_4
    sget-object v0, Lcn/jpush/android/service/PushService;->M:Ljava/lang/String;

    invoke-static {v0}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x62

    aget-object v3, v3, v5

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcn/jpush/android/service/PushService;->L:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-object v3, v0

    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_1

    :catch_1
    move-exception v0

    move-object v0, v1

    :goto_5
    :try_start_5
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget v1, Lcn/jpush/android/service/PushService;->N:I

    if-eq v1, v8, :cond_c

    const/16 v1, 0x50

    sput v1, Lcn/jpush/android/service/PushService;->N:I

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->d()V

    sget v1, Lcn/jpush/android/service/PushService;->D:I

    add-int/lit8 v1, v1, 0x1

    rem-int/lit8 v1, v1, 0x3

    sput v1, Lcn/jpush/android/service/PushService;->D:I

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x5c

    aget-object v2, v2, v3

    sget v3, Lcn/jpush/android/service/PushService;->D:I

    invoke-static {v1, v2, v3}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/net/DatagramSocket;->close()V

    goto/16 :goto_0

    :cond_4
    :try_start_6
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v6, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0x5d

    aget-object v6, v6, v7

    invoke-direct {v0, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v6, Lcn/jpush/android/service/PushService;->N:I

    add-int/lit16 v6, v6, 0x2710

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    new-instance v0, Ljava/net/DatagramPacket;

    sget v6, Lcn/jpush/android/service/PushService;->N:I

    add-int/lit16 v6, v6, 0x2710

    invoke-direct {v0, v5, v2, v3, v6}, Ljava/net/DatagramPacket;-><init>([BILjava/net/InetAddress;I)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto/16 :goto_3

    :catchall_0
    move-exception v0

    :goto_6
    if-eqz v1, :cond_5

    invoke-virtual {v1}, Ljava/net/DatagramSocket;->close()V

    :cond_5
    throw v0

    :cond_6
    :try_start_7
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-lez v2, :cond_7

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x3a

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    const/4 v4, -0x1

    if-ne v3, v4, :cond_b

    sput-object v2, Lcn/jpush/android/service/PushService;->I:Ljava/lang/String;

    :cond_7
    :goto_7
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v2

    if-lt v2, v9, :cond_a

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_9

    const/16 v3, 0x3a

    invoke-virtual {v2, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    if-lez v3, :cond_9

    const/4 v4, 0x0

    invoke-virtual {v2, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcn/jpush/android/service/PushService;->o:Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_8

    sput-object v4, Lcn/jpush/android/service/PushService;->o:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    sget-object v6, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0x58

    aget-object v6, v6, v7

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    sget-object v6, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0x61

    aget-object v6, v6, v7

    invoke-static {v5, v6, v4}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :cond_8
    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    sget v3, Lcn/jpush/android/service/PushService;->p:I

    if-eq v3, v2, :cond_9

    sput v2, Lcn/jpush/android/service/PushService;->p:I

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x5f

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x59

    aget-object v3, v3, v4

    sget v4, Lcn/jpush/android/service/PushService;->p:I

    invoke-static {v2, v3, v4}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V

    :cond_9
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v2

    const/4 v3, 0x3

    if-lt v2, v3, :cond_a

    const/4 v2, 0x2

    invoke-virtual {v0, v2}, Lorg/json/JSONArray;->optString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_a

    invoke-static {}, Lcn/jpush/android/util/ac;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_a

    invoke-static {v0}, Lcn/jpush/android/util/ac;->a(Ljava/lang/String;)Ljava/lang/String;

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x5a

    aget-object v3, v3, v4

    invoke-static {v2, v3, v0}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :cond_a
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Lcn/jpush/android/service/PushService;->ae:J

    goto/16 :goto_4

    :cond_b
    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x8

    aget-object v4, v4, v5

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x60

    aget-object v5, v5, v6

    invoke-static {v4, v5}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v4, 0x0

    invoke-virtual {v2, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    sput-object v4, Lcn/jpush/android/service/PushService;->I:Ljava/lang/String;

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    sput v2, Lcn/jpush/android/service/PushService;->K:I
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    goto/16 :goto_7

    :cond_c
    const/16 v1, 0x2328

    :try_start_8
    sput v1, Lcn/jpush/android/service/PushService;->N:I
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/net/DatagramSocket;->close()V

    goto/16 :goto_0

    :catchall_1
    move-exception v1

    move-object v10, v1

    move-object v1, v0

    move-object v0, v10

    goto/16 :goto_6

    :catchall_2
    move-exception v1

    move-object v10, v1

    move-object v1, v0

    move-object v0, v10

    goto/16 :goto_6

    :catch_2
    move-exception v1

    goto/16 :goto_5

    :cond_d
    move v2, v0

    goto/16 :goto_2
.end method

.method protected final e()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, v0, v0, v0}, Lcn/jpush/android/service/PushService;->a(ZZZ)V

    return-void
.end method

.method protected final e(I)V
    .locals 11

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->w:[B

    invoke-static {v0}, Lcn/jpush/android/util/a;->b([B)I

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x3c

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->e()V

    const/4 v1, 0x3

    if-eq v0, v1, :cond_2

    const/16 v1, 0x9

    if-ne v0, v1, :cond_1c

    :cond_2
    const/16 v1, 0x9

    if-ne v0, v1, :cond_3

    const/4 v0, 0x1

    :goto_1
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x35

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/16 v2, 0x14

    const/4 v3, 0x1

    invoke-static {v1, v2, v3}, Lcn/jpush/android/util/aa;->b([BII)I

    move-result v10

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/16 v2, 0x15

    const/16 v3, 0x8

    invoke-static {v1, v2, v3}, Lcn/jpush/android/util/aa;->c([BII)J

    move-result-wide v5

    const/4 v1, 0x0

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x4a

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x49

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/16 v2, 0x1d

    const/4 v3, 0x2

    invoke-static {v0, v2, v3}, Lcn/jpush/android/util/aa;->b([BII)I

    move-result v0

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/16 v3, 0x1f

    invoke-static {v2, v3, v0}, Lcn/jpush/android/util/aa;->d([BII)Ljava/lang/String;

    move-result-object v3

    add-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/4 v4, 0x2

    invoke-static {v2, v0, v4}, Lcn/jpush/android/util/aa;->b([BII)I

    move-result v4

    add-int/lit8 v0, v0, 0x2

    iget-object v2, p0, Lcn/jpush/android/service/PushService;->w:[B

    invoke-static {v2, v0, v4}, Lcn/jpush/android/util/aa;->d([BII)Ljava/lang/String;

    move-result-object v2

    add-int/2addr v0, v4

    iget-object v4, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/4 v7, 0x1

    invoke-static {v4, v0, v7}, Lcn/jpush/android/util/aa;->b([BII)I

    move-result v4

    new-instance v7, Ljava/lang/StringBuilder;

    sget-object v8, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v9, 0x43

    aget-object v8, v8, v9

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    add-int/lit8 v0, v0, 0x1

    iget-object v7, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/4 v8, 0x2

    invoke-static {v7, v0, v8}, Lcn/jpush/android/util/aa;->b([BII)I

    move-result v7

    add-int/lit8 v0, v0, 0x2

    const/4 v8, 0x1

    if-ne v4, v8, :cond_4

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->w:[B

    invoke-static {v1, v0, v7}, Lcn/jpush/android/util/aa;->a([BII)Ljava/lang/String;

    move-result-object v0

    move-object v7, v0

    move-object v8, v2

    move-object v9, v3

    :goto_2
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x4b

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x45

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x42

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    packed-switch v10, :pswitch_data_0

    :pswitch_0
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x3e

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto/16 :goto_0

    :cond_3
    const/4 v0, 0x0

    goto/16 :goto_1

    :cond_4
    if-nez v4, :cond_5

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->w:[B

    invoke-static {v1, v0, v7}, Lcn/jpush/android/util/aa;->d([BII)Ljava/lang/String;

    move-result-object v0

    move-object v7, v0

    move-object v8, v2

    move-object v9, v3

    goto :goto_2

    :cond_5
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v7, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v8, 0x3d

    aget-object v7, v7, v8

    invoke-direct {v0, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    move-object v7, v1

    move-object v8, v2

    move-object v9, v3

    goto :goto_2

    :cond_6
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/16 v1, 0x1d

    const/4 v2, 0x2

    invoke-static {v0, v1, v2}, Lcn/jpush/android/util/aa;->b([BII)I

    move-result v0

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->w:[B

    const/16 v2, 0x1f

    invoke-static {v1, v2, v0}, Lcn/jpush/android/util/aa;->d([BII)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/io/LineNumberReader;

    new-instance v2, Ljava/io/StringReader;

    invoke-direct {v2, v0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-direct {v1, v2}, Ljava/io/LineNumberReader;-><init>(Ljava/io/Reader;)V

    :try_start_0
    invoke-virtual {v1}, Ljava/io/LineNumberReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_7

    invoke-static {}, Lcn/jpush/android/util/x;->f()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    goto/16 :goto_0

    :cond_7
    :try_start_1
    invoke-virtual {v1}, Ljava/io/LineNumberReader;->readLine()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_8

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_0

    :cond_8
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0x2

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v7, v3, 0x1

    if-le v4, v7, :cond_9

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    move-object v7, v0

    move-object v8, v1

    move-object v9, v2

    goto/16 :goto_2

    :cond_9
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const-string v0, ""
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    move-object v7, v0

    move-object v8, v1

    move-object v9, v2

    goto/16 :goto_2

    :pswitch_1
    const/16 v0, 0x14

    if-le p1, v0, :cond_0

    :try_start_2
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x34

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/service/ServiceInterface;->j(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_a

    invoke-static {}, Lcn/jpush/android/util/x;->d()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_0

    :catch_1
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    goto/16 :goto_0

    :cond_a
    :try_start_3
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->o(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_d

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_b

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    const/4 v1, 0x0

    sget-wide v2, Lcn/jpush/android/service/PushService;->s:J

    int-to-byte v4, v10

    invoke-static/range {v0 .. v6}, Lcn/jpush/android/service/PushProtocol;->MsgResponse(IIJBJ)I

    :cond_b
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v7, v9, v8, v1}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcn/jpush/android/data/a;

    move-result-object v0

    if-nez v0, :cond_c

    :goto_3
    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    goto/16 :goto_0

    :cond_c
    iget-object v0, v0, Lcn/jpush/android/data/a;->c:Ljava/lang/String;

    const/16 v1, 0x406

    sget-object v2, Lcn/jpush/android/a;->d:Landroid/content/Context;

    invoke-static {v0, v1, v2}, Lcn/jpush/android/service/ServiceInterface;->a(Ljava/lang/String;ILandroid/content/Context;)V

    goto :goto_3

    :cond_d
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-nez v0, :cond_f

    invoke-direct {p0, v10, v5, v6}, Lcn/jpush/android/service/PushService;->a(IJ)V

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x3a

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    :goto_4
    new-instance v1, Lcn/jpush/android/util/aj;

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x8

    aget-object v0, v0, v2

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x33

    aget-object v2, v2, v3

    invoke-direct {v1, v0, v2}, Lcn/jpush/android/util/aj;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1b

    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1b

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1a

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x44

    aget-object v2, v2, v3

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v7, v9, v8, v2}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcn/jpush/android/data/a;

    move-result-object v2

    if-nez v2, :cond_11

    :cond_e
    :goto_5
    invoke-virtual {v1}, Lcn/jpush/android/util/aj;->a()V

    goto/16 :goto_0

    :cond_f
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    const/4 v1, 0x0

    sget-wide v2, Lcn/jpush/android/service/PushService;->s:J

    int-to-byte v4, v10

    invoke-static/range {v0 .. v6}, Lcn/jpush/android/service/PushProtocol;->MsgResponse(IIJBJ)I

    move-result v0

    if-eqz v0, :cond_10

    invoke-direct {p0, v10, v5, v6}, Lcn/jpush/android/service/PushService;->a(IJ)V

    goto :goto_4

    :cond_10
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x3f

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto :goto_4

    :cond_11
    invoke-virtual {v2}, Lcn/jpush/android/data/a;->h()Lcn/jpush/android/data/e;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->aj:Ljava/util/Queue;

    invoke-interface {v3, v0}, Ljava/util/Queue;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_12

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x39

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto :goto_5

    :cond_12
    sget-object v3, Lcn/jpush/android/service/PushService;->aj:Ljava/util/Queue;

    invoke-interface {v3}, Ljava/util/Queue;->size()I

    move-result v3

    const/16 v4, 0xc8

    if-lt v3, v4, :cond_13

    sget-object v3, Lcn/jpush/android/service/PushService;->aj:Ljava/util/Queue;

    invoke-interface {v3}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    :cond_13
    sget-object v3, Lcn/jpush/android/service/PushService;->aj:Ljava/util/Queue;

    invoke-interface {v3, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    const/4 v0, 0x0

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x36

    aget-object v3, v3, v4

    invoke-virtual {v8, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_17

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3, v2}, Lcn/jpush/android/data/p;->a(Landroid/content/Context;Lcn/jpush/android/data/a;)V

    :cond_14
    :goto_6
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x3b

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    and-int/lit8 v4, v0, 0x1

    if-eqz v4, :cond_15

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/4 v4, 0x1

    iput-boolean v4, v2, Lcn/jpush/android/data/a;->h:Z

    new-instance v4, Landroid/content/Intent;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x47

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x37

    aget-object v5, v5, v6

    invoke-virtual {v4, v5, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x4d

    aget-object v5, v5, v6

    invoke-virtual {v4, v5, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x46

    aget-object v5, v5, v6

    invoke-virtual {v4, v5, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x32

    aget-object v5, v5, v6

    invoke-virtual {v4, v5, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x40

    aget-object v3, v3, v5

    iget v5, v2, Lcn/jpush/android/data/a;->g:I

    invoke-virtual {v4, v3, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    invoke-virtual {v4, v9}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x31

    aget-object v5, v5, v6

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v4, v3}, Lcn/jpush/android/service/PushService;->sendOrderedBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    :cond_15
    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_e

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, v2, Lcn/jpush/android/data/a;->i:Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_16

    iget-object v0, v2, Lcn/jpush/android/data/a;->l:Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_e

    :cond_16
    iput-object v9, v2, Lcn/jpush/android/data/a;->m:Ljava/lang/String;

    iput-object v8, v2, Lcn/jpush/android/data/a;->n:Ljava/lang/String;

    invoke-virtual {v2}, Lcn/jpush/android/data/a;->f()Z

    move-result v0

    if-nez v0, :cond_19

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, v2}, Lcn/jpush/android/util/a;->a(Landroid/content/Context;Lcn/jpush/android/data/d;)V

    goto/16 :goto_5

    :cond_17
    iget-boolean v0, v2, Lcn/jpush/android/data/a;->e:Z

    if-eqz v0, :cond_18

    const/4 v0, 0x1

    iget v3, v2, Lcn/jpush/android/data/a;->b:I

    const/4 v4, 0x4

    if-ne v3, v4, :cond_14

    const/4 v0, 0x3

    goto/16 :goto_6

    :cond_18
    const/4 v0, 0x2

    goto/16 :goto_6

    :cond_19
    invoke-static {v2}, Lcn/jpush/android/data/a;->a(Lcn/jpush/android/data/a;)Lcn/jpush/android/data/d;

    move-result-object v0

    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcn/jpush/android/service/j;

    invoke-direct {v3, p0, v0}, Lcn/jpush/android/service/j;-><init>(Lcn/jpush/android/service/PushService;Lcn/jpush/android/data/d;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto/16 :goto_5

    :cond_1a
    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_5

    :cond_1b
    invoke-static {}, Lcn/jpush/android/util/x;->e()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_5

    :pswitch_2
    invoke-direct {p0, v7}, Lcn/jpush/android/service/PushService;->o(Ljava/lang/String;)V

    goto/16 :goto_0

    :pswitch_3
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/service/ServiceInterface;->e(Landroid/content/Context;)V

    goto/16 :goto_0

    :pswitch_4
    invoke-direct {p0, v7}, Lcn/jpush/android/service/PushService;->l(Ljava/lang/String;)V

    goto/16 :goto_0

    :pswitch_5
    invoke-direct {p0, v7}, Lcn/jpush/android/service/PushService;->k(Ljava/lang/String;)V

    goto/16 :goto_0

    :pswitch_6
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcn/jpush/android/service/PushService;->a(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    :pswitch_7
    sget-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-direct {p0, v9, v0}, Lcn/jpush/android/service/PushService;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :pswitch_8
    const/4 v0, 0x0

    invoke-direct {p0, v7, v0}, Lcn/jpush/android/service/PushService;->a(Ljava/lang/String;I)V

    goto/16 :goto_0

    :pswitch_9
    invoke-direct {p0, v7}, Lcn/jpush/android/service/PushService;->j(Ljava/lang/String;)V

    goto/16 :goto_0

    :pswitch_a
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v7, v0}, Lcn/jpush/android/util/JLogger;->parseModalJson(Ljava/lang/String;Landroid/content/Context;)V

    goto/16 :goto_0

    :pswitch_b
    invoke-static {v7}, Lcn/jpush/android/util/JRecorder;->parseRecordCommand(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_1c
    const/4 v1, 0x6

    if-ne v0, v1, :cond_1d

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x28

    aget-object v0, v0, v1

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->n(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_1d
    const/4 v1, 0x7

    if-ne v0, v1, :cond_1e

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x41

    aget-object v0, v0, v1

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->i(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_1e
    const/16 v1, 0xb

    if-ne v0, v1, :cond_1f

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x38

    aget-object v0, v0, v1

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->i(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_1f
    const/16 v1, 0xe

    if-ne v0, v1, :cond_20

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x4c

    aget-object v0, v0, v1

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->n(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_20
    const/16 v1, 0x10

    if-ne v0, v1, :cond_21

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x28

    aget-object v0, v0, v1

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->m(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_21
    const/16 v1, 0x11

    if-ne v0, v1, :cond_22

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x4c

    aget-object v0, v0, v1

    invoke-direct {p0, v0}, Lcn/jpush/android/service/PushService;->m(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_22
    const/16 v1, 0xa

    if-eq v0, v1, :cond_0

    const/16 v1, 0x13

    if-ne v0, v1, :cond_23

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->v()V

    goto/16 :goto_0

    :cond_23
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x48

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto/16 :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_7
        :pswitch_8
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_9
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method

.method protected final f()V
    .locals 2

    const/4 v1, 0x0

    const/4 v0, 0x1

    invoke-direct {p0, v1, v0, v1}, Lcn/jpush/android/service/PushService;->a(ZZZ)V

    return-void
.end method

.method protected final f(I)V
    .locals 9

    const/16 v8, 0x3ed

    const/4 v1, 0x1

    const/4 v2, 0x0

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x8

    aget-object v0, v0, v3

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xda

    aget-object v3, v3, v4

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x11

    aget-object v0, v0, v3

    invoke-virtual {p0, v2, v0}, Lcn/jpush/android/service/PushService;->a(ILjava/lang/String;)V

    const/16 v0, -0x3df

    if-ne p1, v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/service/ServiceInterface;->j(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_5

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->b(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_5

    sget v0, Lcn/jpush/android/service/PushService;->i:I

    const v3, 0x15181

    if-ne v0, v3, :cond_6

    move v0, v1

    :goto_1
    if-nez v0, :cond_5

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->h(Landroid/content/Context;)I

    move-result v3

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->g(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_2

    if-lez v3, :cond_5

    :cond_2
    const-wide/high16 v4, 0x4000000000000000L    # 2.0

    iget v0, p0, Lcn/jpush/android/service/PushService;->ac:I

    int-to-double v6, v0

    invoke-static {v4, v5, v6, v7}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v4

    const-wide/high16 v6, 0x4008000000000000L    # 3.0

    mul-double/2addr v4, v6

    const-wide v6, 0x408f400000000000L    # 1000.0

    mul-double/2addr v4, v6

    double-to-int v0, v4

    iget v4, p0, Lcn/jpush/android/service/PushService;->ac:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcn/jpush/android/service/PushService;->ac:I

    sget v4, Lcn/jpush/android/service/PushService;->i:I

    mul-int/lit16 v4, v4, 0x1f4

    if-le v0, v4, :cond_3

    sget v0, Lcn/jpush/android/service/PushService;->i:I

    mul-int/lit16 v0, v0, 0x1f4

    :cond_3
    iget v4, p0, Lcn/jpush/android/service/PushService;->ac:I

    const/4 v5, 0x5

    if-le v4, v5, :cond_4

    if-ne v3, v1, :cond_5

    :cond_4
    iget-object v1, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    invoke-virtual {v1, v8}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v1

    if-nez v1, :cond_5

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v3, 0x3ec

    invoke-virtual {v1, v3}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v1

    if-nez v1, :cond_5

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xdb

    aget-object v3, v3, v4

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v1, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    int-to-long v3, v0

    invoke-virtual {v1, v8, v3, v4}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    :cond_5
    iput v2, p0, Lcn/jpush/android/service/PushService;->ab:I

    iget v0, p0, Lcn/jpush/android/service/PushService;->af:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcn/jpush/android/service/PushService;->af:I

    sget-boolean v0, Lcn/jpush/android/service/PushService;->W:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3ea

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    goto/16 :goto_0

    :cond_6
    move v0, v2

    goto/16 :goto_1
.end method

.method protected final g()V
    .locals 13

    const/16 v12, 0x7e

    const/4 v11, 0x6

    const/4 v7, 0x0

    const/4 v10, 0x1

    const/4 v9, 0x2

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iput v7, p0, Lcn/jpush/android/service/PushService;->ac:I

    :cond_0
    :goto_0
    iget-object v0, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-eqz v0, :cond_11

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x83

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x71

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    const-string v3, ","

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v0, v3, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget v2, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v3, Lcn/jpush/android/service/PushService;->s:J

    aget-object v1, v1, v10

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->byteValue()B

    move-result v1

    invoke-static {v2, v3, v4, v1, v0}, Lcn/jpush/android/service/PushProtocol;->RepPush(IJBLjava/lang/String;)I

    move-result v1

    if-ltz v1, :cond_1

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x87

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto :goto_0

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x88

    aget-object v2, v2, v3

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :cond_2
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x75

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v1, v1, v11

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    array-length v1, v6

    const/4 v2, 0x3

    if-le v1, v2, :cond_4

    const/4 v0, 0x3

    :try_start_0
    aget-object v0, v6, v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v5

    :goto_1
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v1, Lcn/jpush/android/service/PushService;->s:J

    aget-object v3, v6, v10

    aget-object v4, v6, v9

    invoke-static/range {v0 .. v5}, Lcn/jpush/android/service/PushService;->a(IJLjava/lang/String;Ljava/lang/String;I)I

    move-result v0

    if-ltz v0, :cond_3

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x9

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v2, v6, v9

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/jpush/android/util/x;->c(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :catch_0
    move-exception v0

    move v5, v7

    goto :goto_1

    :cond_3
    aget-object v1, v6, v9

    sget-object v2, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-direct {p0, v1, v2, v5}, Lcn/jpush/android/service/PushService;->a(Ljava/lang/String;Ljava/lang/String;I)V

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x8

    aget-object v1, v1, v2

    new-instance v2, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x86

    aget-object v3, v3, v4

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcn/jpush/android/util/x;->c(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_4
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x7a

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_0

    :cond_5
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x74

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_8

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    array-length v2, v1

    if-le v2, v9, :cond_7

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v2, Lcn/jpush/android/service/PushService;->s:J

    aget-object v4, v1, v10

    aget-object v5, v1, v9

    invoke-static {v0, v2, v3, v4, v5}, Lcn/jpush/android/service/PushProtocol;->EnChannel(IJLjava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-ltz v0, :cond_6

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x77

    aget-object v2, v2, v3

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v2, v1, v10

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v2, v2, v12

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    aget-object v1, v1, v9

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :cond_6
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x6e

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :cond_7
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x85

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_0

    :cond_8
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x78

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_b

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    array-length v2, v1

    if-le v2, v9, :cond_a

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v2, Lcn/jpush/android/service/PushService;->s:J

    aget-object v4, v1, v10

    aget-object v5, v1, v9

    invoke-static {v0, v2, v3, v4, v5}, Lcn/jpush/android/service/PushProtocol;->UnChnelId(IJLjava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-ltz v0, :cond_9

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x76

    aget-object v2, v2, v3

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v2, v1, v10

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v2, v2, v12

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    aget-object v1, v1, v9

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :cond_9
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x79

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :cond_a
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x70

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_0

    :cond_b
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x7c

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_e

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v1, v1, v11

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    array-length v2, v1

    if-le v2, v9, :cond_d

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v2, Lcn/jpush/android/service/PushService;->s:J

    aget-object v4, v1, v10

    aget-object v5, v1, v9

    invoke-static {v0, v2, v3, v4, v5}, Lcn/jpush/android/service/PushProtocol;->PushTime(IJLjava/lang/String;Ljava/lang/String;)I

    move-result v0

    if-ltz v0, :cond_c

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x81

    aget-object v2, v2, v3

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    aget-object v2, v1, v10

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v2, v2, v12

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    aget-object v1, v1, v9

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :cond_c
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x80

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_0

    :cond_d
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x84

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_0

    :cond_e
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x7d

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v1, v1, v11

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    array-length v2, v1

    if-lt v2, v9, :cond_10

    const/4 v0, 0x0

    :try_start_1
    aget-object v0, v1, v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v8

    const/4 v0, 0x1

    aget-object v0, v1, v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v5

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x82

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    const/4 v1, 0x0

    sget-wide v2, Lcn/jpush/android/service/PushService;->s:J

    int-to-byte v4, v8

    invoke-static/range {v0 .. v6}, Lcn/jpush/android/service/PushProtocol;->MsgResponse(IIJBJ)I

    move-result v0

    if-eqz v0, :cond_f

    invoke-direct {p0, v8, v5, v6}, Lcn/jpush/android/service/PushService;->a(IJ)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    :catch_1
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_0

    :cond_f
    :try_start_2
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x3f

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_0

    :cond_10
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x7f

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->f()V

    goto/16 :goto_0

    :cond_11
    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->x()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->C()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x72

    aget-object v1, v1, v2

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xb

    aget-object v2, v2, v3

    invoke-static {v0, v1, v2}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x73

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_12

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    :try_start_3
    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x7b

    aget-object v1, v1, v2

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x89

    aget-object v1, v1, v2

    sget-object v2, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_2

    :goto_2
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcn/jpush/android/service/ServiceInterface;->j(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_17

    iget v1, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v2, Lcn/jpush/android/service/PushService;->s:J

    const/4 v4, 0x4

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v2, v3, v4, v0}, Lcn/jpush/android/service/PushProtocol;->RepPush(IJBLjava/lang/String;)I

    :cond_12
    :goto_3
    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->q()V

    :cond_13
    sget-boolean v0, Lcn/jpush/android/service/PushService;->G:Z

    if-eqz v0, :cond_14

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/service/ServiceInterface;->e(Landroid/content/Context;)V

    :cond_14
    sget-boolean v0, Lcn/jpush/android/service/PushService;->W:Z

    if-eqz v0, :cond_15

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3ea

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    :cond_15
    sget v0, Lcn/jpush/android/service/PushService;->O:I

    if-gtz v0, :cond_16

    sget v0, Lcn/jpush/android/service/PushService;->O:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcn/jpush/android/service/PushService;->O:I

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x6f

    aget-object v1, v1, v2

    sget v2, Lcn/jpush/android/service/PushService;->O:I

    invoke-static {v0, v1, v2}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;I)V

    :cond_16
    return-void

    :cond_17
    iget v1, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v2, Lcn/jpush/android/service/PushService;->s:J

    const/4 v4, 0x5

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v2, v3, v4, v0}, Lcn/jpush/android/service/PushProtocol;->RepPush(IJBLjava/lang/String;)I

    goto :goto_3

    :catch_2
    move-exception v1

    goto :goto_2
.end method

.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreate()V
    .locals 8

    const/4 v3, 0x0

    const/4 v6, 0x1

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/service/ServiceInterface;->j(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getId()J

    move-result-wide v0

    sput-wide v0, Lcn/jpush/android/service/PushService;->a:J

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/a;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->q(Landroid/content/Context;)Z

    move-result v0

    iput-boolean v0, p0, Lcn/jpush/android/service/PushService;->U:Z

    iget-boolean v0, p0, Lcn/jpush/android/service/PushService;->U:Z

    if-eqz v0, :cond_0

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/a;->f:Ljava/lang/String;

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Lcn/jpush/android/a;->f:Ljava/lang/String;

    sput-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    :cond_2
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v1, v1, v6

    const-string v2, ""

    invoke-static {v0, v1, v2}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    sget-object v1, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->s()V

    :cond_3
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v1, v1, v6

    sget-object v2, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;)V

    iput-boolean v3, p0, Lcn/jpush/android/service/PushService;->R:Z

    iput-boolean v3, p0, Lcn/jpush/android/service/PushService;->S:Z

    sget-object v1, Lcn/jpush/android/a;->d:Landroid/content/Context;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    const/4 v0, 0x0

    :try_start_0
    invoke-static {v1}, Lcn/jpush/android/data/r;->b(Landroid/content/Context;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    if-eqz v0, :cond_9

    :try_start_1
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_9

    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v3, 0x2

    aget-object v2, v2, v3

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    :goto_1
    invoke-interface {v0}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v1

    if-nez v1, :cond_9

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    sget-object v2, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v3, 0x4

    aget-object v2, v2, v3

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    invoke-interface {v3, v2}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/4 v5, 0x3

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, v1}, Lcn/jpush/android/data/r;->b(Landroid/content/Context;I)Z

    :cond_4
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_1

    :catch_0
    move-exception v1

    :try_start_2
    invoke-static {}, Lcn/jpush/android/util/x;->j()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    if-eqz v0, :cond_5

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    :cond_5
    :goto_2
    iget-boolean v0, p0, Lcn/jpush/android/service/PushService;->R:Z

    if-eqz v0, :cond_b

    iput-boolean v6, p0, Lcn/jpush/android/service/PushService;->T:Z

    :cond_6
    :goto_3
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iput-boolean v6, p0, Lcn/jpush/android/service/PushService;->T:Z

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-boolean v0, p0, Lcn/jpush/android/service/PushService;->T:Z

    if-eqz v0, :cond_0

    sget-boolean v0, Lcn/jpush/android/service/PushService;->W:Z

    if-eqz v0, :cond_7

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->b(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_8

    :cond_7
    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    :cond_8
    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->A()V

    goto/16 :goto_0

    :cond_9
    if-eqz v0, :cond_5

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    goto :goto_2

    :catchall_0
    move-exception v1

    move-object v7, v1

    move-object v1, v0

    move-object v0, v7

    :goto_4
    if-eqz v1, :cond_a

    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    :cond_a
    throw v0

    :cond_b
    iget-boolean v0, p0, Lcn/jpush/android/service/PushService;->S:Z

    if-nez v0, :cond_6

    iput-boolean v6, p0, Lcn/jpush/android/service/PushService;->T:Z

    goto :goto_3

    :catchall_1
    move-exception v1

    move-object v7, v1

    move-object v1, v0

    move-object v0, v7

    goto :goto_4
.end method

.method public onDestroy()V
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0x4e

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->z()V

    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->w()V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    sget-boolean v0, Lcn/jpush/android/service/PushService;->W:Z

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->r(Landroid/content/Context;)V

    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 11

    const/16 v7, 0xc9

    const/16 v4, 0xc5

    const/4 v10, 0x0

    const/16 v6, 0xcd

    const/4 v9, 0x1

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xd3

    aget-object v1, v1, v2

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xd1

    aget-object v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    iget-boolean v0, p0, Lcn/jpush/android/service/PushService;->U:Z

    if-nez v0, :cond_1

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3eb

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    :cond_0
    :goto_0
    return v9

    :cond_1
    sget-boolean v0, Lcn/jpush/android/service/PushService;->W:Z

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcn/jpush/android/util/a;->b(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3eb

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0

    :cond_2
    const/4 v1, 0x0

    const/4 v0, 0x0

    if-eqz p1, :cond_27

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    move-object v2, v1

    move-object v1, v0

    :goto_1
    if-eqz v1, :cond_6

    if-eqz v2, :cond_6

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xcc

    aget-object v0, v0, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v0, v0, v9

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    if-eqz v0, :cond_3

    sput-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    :cond_3
    iget v0, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->Q:Lcn/jpush/android/service/n;

    invoke-virtual {v0}, Lcn/jpush/android/service/n;->isAlive()Z

    move-result v0

    if-nez v0, :cond_b

    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xd2

    aget-object v3, v3, v4

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Lcn/jpush/android/service/PushService;->v:I

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    :cond_5
    :goto_2
    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    :cond_6
    if-eqz v2, :cond_8

    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xc0

    aget-object v3, v3, v4

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Landroid/os/Bundle;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x91

    aget-object v0, v0, v3

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xd4

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, v10}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    if-eqz v0, :cond_7

    if-nez v3, :cond_26

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v3, 0x3ed

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v3, 0x3ec

    invoke-virtual {v0, v3}, Landroid/os/Handler;->hasMessages(I)Z

    move-result v0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v3, 0x3ed

    invoke-virtual {v0, v3}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    :cond_7
    :goto_3
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xaa

    aget-object v0, v0, v3

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_8

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xbb

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xa2

    aget-object v3, v3, v4

    invoke-virtual {v2, v3, v10}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v3

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xa7

    aget-object v4, v4, v5

    invoke-virtual {v2, v4, v10}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    invoke-direct {p0, p0, v0, v3, v4}, Lcn/jpush/android/service/PushService;->a(Landroid/content/Context;Ljava/lang/String;ZZ)Lcn/jpush/android/a/d;

    move-result-object v0

    invoke-virtual {v0}, Lcn/jpush/android/a/d;->f()V

    :cond_8
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x72

    aget-object v3, v3, v4

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xb

    aget-object v4, v4, v5

    invoke-static {v0, v3, v4}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x73

    aget-object v3, v3, v4

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    sget-boolean v3, Lcn/jpush/android/service/PushService;->W:Z

    if-nez v3, :cond_9

    iget-boolean v3, p0, Lcn/jpush/android/service/PushService;->T:Z

    if-eqz v3, :cond_9

    if-eqz v0, :cond_a

    :cond_9
    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->q()V

    :cond_a
    if-eqz v1, :cond_0

    if-nez v2, :cond_0

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v2, 0xc2

    aget-object v0, v0, v2

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->A()V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3ed

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3ec

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    iget-object v0, p0, Lcn/jpush/android/service/PushService;->an:Landroid/os/Handler;

    const/16 v1, 0x3ec

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_0

    :cond_b
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x8

    aget-object v0, v0, v3

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xba

    aget-object v3, v3, v4

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_c
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x41

    aget-object v0, v0, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    iget-boolean v0, p0, Lcn/jpush/android/service/PushService;->T:Z

    if-eqz v0, :cond_d

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v0, v0, v4

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-direct {p0, v0, v3}, Lcn/jpush/android/service/PushService;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_d
    invoke-static {p0}, Lcn/jpush/android/service/ServiceInterface;->i(Landroid/content/Context;)I

    move-result v0

    const/4 v3, 0x2

    if-ne v0, v3, :cond_e

    invoke-static {p0}, Lcn/jpush/android/service/ServiceInterface;->h(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_e

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v0, v0, v4

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-direct {p0, v0, v3}, Lcn/jpush/android/service/PushService;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_e
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    sget-object v0, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    goto/16 :goto_2

    :cond_f
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xc3

    aget-object v0, v0, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x71

    aget-object v0, v0, v3

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_5

    iget-boolean v3, p0, Lcn/jpush/android/service/PushService;->T:Z

    if-eqz v3, :cond_12

    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xce

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->d()V

    iget v3, p0, Lcn/jpush/android/service/PushService;->v:I

    if-nez v3, :cond_10

    const/4 v3, 0x3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3, v0}, Lcn/jpush/android/service/PushService;->g(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_10
    iget v3, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v4, Lcn/jpush/android/service/PushService;->s:J

    const/4 v6, 0x3

    invoke-static {v3, v4, v5, v6, v0}, Lcn/jpush/android/service/PushProtocol;->RepPush(IJBLjava/lang/String;)I

    move-result v3

    if-gez v3, :cond_11

    const/4 v3, 0x3

    invoke-static {v3}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3, v0}, Lcn/jpush/android/service/PushService;->g(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_11
    new-instance v3, Ljava/lang/StringBuilder;

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0x87

    aget-object v4, v4, v5

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_2

    :cond_12
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto/16 :goto_2

    :cond_13
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xd0

    aget-object v0, v0, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_14

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xcb

    aget-object v0, v0, v3

    const/4 v3, -0x1

    invoke-virtual {v2, v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    const/4 v3, -0x1

    if-eq v0, v3, :cond_5

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto/16 :goto_2

    :cond_14
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xc7

    aget-object v0, v0, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xac

    aget-object v0, v0, v3

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xad

    aget-object v3, v3, v4

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xbd

    aget-object v4, v4, v5

    invoke-virtual {v2, v4, v10}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v4

    if-nez v0, :cond_15

    if-eqz v3, :cond_5

    :cond_15
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    if-eqz v0, :cond_16

    :try_start_0
    sget-object v6, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0xac

    aget-object v6, v6, v7

    invoke-virtual {v5, v6, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_16
    if-eqz v3, :cond_17

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xad

    aget-object v0, v0, v6

    invoke-virtual {v5, v0, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    :cond_17
    invoke-virtual {v5}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5}, Lorg/json/JSONObject;->length()I

    move-result v3

    if-lez v3, :cond_5

    iget-boolean v3, p0, Lcn/jpush/android/service/PushService;->T:Z

    if-eqz v3, :cond_18

    invoke-direct {p0, v0, v4}, Lcn/jpush/android/service/PushService;->a(Ljava/lang/String;I)V

    goto/16 :goto_2

    :catch_0
    move-exception v0

    goto/16 :goto_2

    :cond_18
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xc1

    aget-object v3, v3, v4

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_2

    :cond_19
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0x38

    aget-object v0, v0, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1b

    iget-boolean v0, p0, Lcn/jpush/android/service/PushService;->T:Z

    if-eqz v0, :cond_1a

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v0, v0, v4

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sget-object v3, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-direct {p0, v0, v3}, Lcn/jpush/android/service/PushService;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_1a
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xc1

    aget-object v3, v3, v4

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto/16 :goto_2

    :cond_1b
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xbc

    aget-object v0, v0, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_23

    iget-boolean v0, p0, Lcn/jpush/android/service/PushService;->T:Z

    if-eqz v0, :cond_22

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v0, v0, v6

    invoke-virtual {v2, v0, v9}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v3, v3, v7

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-eqz v0, :cond_1c

    const-string v0, "0"

    :goto_4
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v5, v5, v6

    const-string v6, "0"

    invoke-static {v4, v5, v6}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1d

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    aget-object v5, v5, v7

    const-string v6, ""

    invoke-static {v4, v5, v6}, Lcn/jpush/android/util/ae;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1d

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x8

    aget-object v0, v0, v4

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xc8

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcn/jpush/android/util/x;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_1c
    const-string v0, "1"

    goto :goto_4

    :cond_1d
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    :try_start_1
    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xcd

    aget-object v5, v5, v6

    invoke-virtual {v4, v5, v0}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    invoke-static {v3}, Lcn/jpush/android/util/ai;->a(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1e

    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v5, 0xc9

    aget-object v0, v0, v5

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xcf

    aget-object v5, v5, v6

    sget-object v6, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0xbf

    aget-object v6, v6, v7

    invoke-virtual {v3, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v0, v5}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_2

    :cond_1e
    invoke-virtual {v4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    :try_start_2
    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    sget-object v6, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v7, 0xcd

    aget-object v6, v6, v7

    sget-object v7, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v8, 0xcd

    aget-object v7, v7, v8

    invoke-virtual {v4, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v5, v6, v4}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/jpush/android/service/PushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xc9

    aget-object v5, v5, v6

    invoke-static {v4, v5, v3}, Lcn/jpush/android/util/ae;->b(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    :goto_5
    iget v3, p0, Lcn/jpush/android/service/PushService;->v:I

    if-eqz v3, :cond_1f

    sget-wide v3, Lcn/jpush/android/service/PushService;->s:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-nez v3, :cond_20

    :cond_1f
    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xca

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v5, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x1d

    aget-object v5, v5, v6

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    goto/16 :goto_2

    :catch_1
    move-exception v3

    invoke-static {}, Lcn/jpush/android/util/x;->j()V

    goto :goto_5

    :cond_20
    iget v3, p0, Lcn/jpush/android/service/PushService;->v:I

    sget-wide v4, Lcn/jpush/android/service/PushService;->s:J

    sget-object v6, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-static {v3, v4, v5, v6, v0}, Lcn/jpush/android/service/PushProtocol;->PushTime(IJLjava/lang/String;Ljava/lang/String;)I

    move-result v3

    if-gez v3, :cond_21

    iget-object v3, p0, Lcn/jpush/android/service/PushService;->x:Ljava/util/Queue;

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xca

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v5, Lcn/jpush/android/service/PushService;->P:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0x1d

    aget-object v5, v5, v6

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/Queue;->offer(Ljava/lang/Object;)Z

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->y()V

    goto/16 :goto_2

    :cond_21
    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0x8

    aget-object v3, v3, v4

    new-instance v4, Ljava/lang/StringBuilder;

    sget-object v5, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v6, 0xc6

    aget-object v5, v5, v6

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lcn/jpush/android/util/x;->c(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    :cond_22
    new-instance v0, Ljava/lang/StringBuilder;

    sget-object v3, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v4, 0xc1

    aget-object v3, v3, v4

    invoke-direct {v0, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {}, Lcn/jpush/android/util/x;->c()V

    goto/16 :goto_2

    :cond_23
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xc4

    aget-object v0, v0, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_24

    invoke-direct {p0}, Lcn/jpush/android/service/PushService;->w()V

    goto/16 :goto_2

    :cond_24
    sget-object v0, Lcn/jpush/android/service/PushService;->bb:[Ljava/lang/String;

    const/16 v3, 0xbe

    aget-object v0, v0, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_25

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    iget-boolean v0, p0, Lcn/jpush/android/service/PushService;->ai:Z

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcn/jpush/android/service/k;

    invoke-direct {v1, p0}, Lcn/jpush/android/service/k;-><init>(Lcn/jpush/android/service/PushService;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto/16 :goto_0

    :cond_25
    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto/16 :goto_2

    :cond_26
    invoke-direct {p0, v3}, Lcn/jpush/android/service/PushService;->g(I)V

    goto/16 :goto_3

    :catch_2
    move-exception v0

    goto/16 :goto_2

    :cond_27
    move-object v2, v1

    move-object v1, v0

    goto/16 :goto_1
.end method
