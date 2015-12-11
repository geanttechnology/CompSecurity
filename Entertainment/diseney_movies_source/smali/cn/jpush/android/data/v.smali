.class final Lcn/jpush/android/data/v;
.super Landroid/database/sqlite/SQLiteOpenHelper;


# static fields
.field private static final z:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 14

    const/4 v2, 0x1

    const/4 v1, 0x0

    const/4 v0, 0x3

    new-array v4, v0, [Ljava/lang/String;

    const-string v3, "Ca4 7vb52+@b5:<Z?%1"

    const/4 v0, -0x1

    move-object v5, v4

    move-object v6, v4

    move v4, v1

    :goto_0
    invoke-virtual {v3}, Ljava/lang/String;->toCharArray()[C

    move-result-object v3

    array-length v7, v3

    if-gt v7, v2, :cond_2

    move v8, v1

    :cond_0
    move-object v9, v3

    move v10, v8

    move v13, v7

    move-object v7, v3

    move v3, v13

    :goto_1
    aget-char v12, v7, v8

    rem-int/lit8 v11, v10, 0x5

    packed-switch v11, :pswitch_data_0

    const/16 v11, 0x5f

    :goto_2
    xor-int/2addr v11, v12

    int-to-char v11, v11

    aput-char v11, v7, v8

    add-int/lit8 v8, v10, 0x1

    if-nez v3, :cond_1

    move-object v7, v9

    move v10, v8

    move v8, v3

    goto :goto_1

    :cond_1
    move v7, v3

    move-object v3, v9

    :goto_3
    if-gt v7, v8, :cond_0

    new-instance v7, Ljava/lang/String;

    invoke-direct {v7, v3}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v7}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    packed-switch v0, :pswitch_data_1

    aput-object v3, v5, v4

    const-string v0, "jC\u0004\u0012\u000bl1\u0015\u0012\u001deTa9/\\b)\u000c,]p5:,]x\" \u007f\u0001N(7\u007f`_\u0015\u0016\u0018lCa\u0003\r`\\\u0000\u0001\u0006\tZ\u0004\n\u007fhD\u0015\u001c\u0016gR\u0013\u0016\u0012l_\u0015ssZe\u001e 0[e\u001e8:P156\']1/<+\t\u007f4?3\u0005b5\u000c1Lea\':Qea=0]1/&3E=2\'\u0000J~/=\u0000@aa\':Qea=0]1/&3E=2\'\u0000E~\"23vu/ \u007f]t9\'sZe\u001e 0\\c\"6\u007f@\u007f568Lca=0]1/&3E=2\'\u0000Op(?:M1(=+Lv$!\u007fG~5s1\\}-\u007f,]N5<+H}a:1]t&6-\t\u007f.\'\u007fGd-?sZe\u001e00\\\u007f5\u000cn\tx/\':Nt3\u007f,]N\"<*Ge\u001eb\u0000\u001a1(=+Lv$!sZe\u001e00\\\u007f5\u000clv qs6Ge$4:[=2\'\u0000J~4=+v qs6Ge$4:[8z"

    move-object v3, v0

    move v4, v2

    move-object v5, v6

    move v0, v1

    goto :goto_0

    :pswitch_0
    aput-object v3, v5, v4

    const/4 v3, 0x2

    const-string v0, "mC\u000e\u0003\u007f}P\u0003\u001f\u001a\tX\u0007s\u001aqX\u0012\u0007\u000c\t{1&,AN2\'>]x2\'6Jb"

    move v4, v3

    move-object v5, v6

    move-object v3, v0

    move v0, v2

    goto :goto_0

    :pswitch_1
    aput-object v3, v5, v4

    sput-object v6, Lcn/jpush/android/data/v;->z:[Ljava/lang/String;

    return-void

    :pswitch_2
    const/16 v11, 0x29

    goto :goto_2

    :pswitch_3
    const/16 v11, 0x11

    goto :goto_2

    :pswitch_4
    const/16 v11, 0x41

    goto :goto_2

    :pswitch_5
    const/16 v11, 0x53

    goto :goto_2

    :cond_2
    move v8, v1

    goto :goto_3

    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch

    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3

    sget-object v0, Lcn/jpush/android/data/v;->z:[Ljava/lang/String;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-direct {p0, p1, v0, v1, v2}, Lcn/jpush/android/data/v;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v0, v1}, Landroid/database/sqlite/SQLiteOpenHelper;-><init>(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V

    return-void
.end method


# virtual methods
.method public final onCreate(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 2

    :try_start_0
    sget-object v0, Lcn/jpush/android/data/v;->z:[Ljava/lang/String;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-static {}, Lcn/jpush/android/util/x;->b()V

    goto :goto_0
.end method

.method public final onUpgrade(Landroid/database/sqlite/SQLiteDatabase;II)V
    .locals 2

    sget-object v0, Lcn/jpush/android/data/v;->z:[Ljava/lang/String;

    const/4 v1, 0x2

    aget-object v0, v0, v1

    invoke-virtual {p1, v0}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    invoke-virtual {p0, p1}, Lcn/jpush/android/data/v;->onCreate(Landroid/database/sqlite/SQLiteDatabase;)V

    return-void
.end method
