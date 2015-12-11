.class public Lnb;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static C:Z

.field public static c:Z

.field public static d:[Ljava/lang/String;

.field public static e:Ljava/lang/String;

.field public static f:I

.field public static final g:Ljava/util/concurrent/Executor;

.field public static final h:Ljava/util/concurrent/Executor;

.field public static k:Ljava/lang/String;

.field public static l:Ljava/lang/String;

.field public static m:Ljava/lang/String;

.field public static n:Ljava/lang/String;

.field private static final o:Ljava/lang/String;

.field private static p:Lnb;


# instance fields
.field private A:Lmr;

.field private B:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private D:D

.field private E:D

.field private F:Z

.field private G:Landroid/support/v4/app/Fragment;

.field private H:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private I:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private J:Z

.field private K:Z

.field private L:Z

.field private M:Z

.field private N:Z

.field private O:Z

.field private P:Ljava/lang/String;

.field private Q:Ljava/lang/String;

.field private R:Z

.field private S:Ljava/lang/String;

.field public a:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public b:Llr;

.field public i:Ljava/lang/String;

.field public j:Ljava/util/Stack;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Stack",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private q:F

.field private r:F

.field private s:F

.field private t:I

.field private u:I

.field private v:F

.field private w:F

.field private x:Landroid/view/Display;

.field private y:Ljava/lang/String;

.field private z:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 56
    const-class v0, Lnb;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lnb;->o:Ljava/lang/String;

    .line 84
    sput-boolean v2, Lnb;->c:Z

    .line 105
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "Sidemenu"

    aput-object v1, v0, v2

    const-string v1, "Hometiles"

    aput-object v1, v0, v3

    const/4 v1, 0x2

    const-string v2, "Dealcards"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "StoresOutletItems"

    aput-object v2, v0, v1

    sput-object v0, Lnb;->d:[Ljava/lang/String;

    .line 106
    const-string v0, "phone:Android"

    sput-object v0, Lnb;->e:Ljava/lang/String;

    .line 107
    sput-boolean v3, Lnb;->C:Z

    .line 115
    sput v3, Lnb;->f:I

    .line 147
    sget-object v0, Landroid/os/AsyncTask;->SERIAL_EXECUTOR:Ljava/util/concurrent/Executor;

    sput-object v0, Lnb;->g:Ljava/util/concurrent/Executor;

    .line 148
    sget-object v0, Landroid/os/AsyncTask;->SERIAL_EXECUTOR:Ljava/util/concurrent/Executor;

    sput-object v0, Lnb;->h:Ljava/util/concurrent/Executor;

    .line 158
    const-string v0, "entry_point"

    sput-object v0, Lnb;->k:Ljava/lang/String;

    .line 159
    const-string v0, "pageName"

    sput-object v0, Lnb;->l:Ljava/lang/String;

    .line 161
    const-string v0, "fromSideNav"

    sput-object v0, Lnb;->m:Ljava/lang/String;

    .line 162
    const-string v0, "fromShake"

    sput-object v0, Lnb;->n:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v0, 0x0

    const/4 v1, 0x0

    .line 194
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 59
    iput v0, p0, Lnb;->q:F

    .line 60
    iput v0, p0, Lnb;->r:F

    .line 61
    iput v0, p0, Lnb;->s:F

    .line 62
    iput v1, p0, Lnb;->t:I

    .line 63
    iput v1, p0, Lnb;->u:I

    .line 64
    iput v0, p0, Lnb;->v:F

    .line 65
    iput v0, p0, Lnb;->w:F

    .line 66
    iput-object v2, p0, Lnb;->x:Landroid/view/Display;

    .line 68
    const-string v0, ""

    iput-object v0, p0, Lnb;->y:Ljava/lang/String;

    .line 98
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lnb;->B:Ljava/util/ArrayList;

    .line 132
    iput-boolean v1, p0, Lnb;->F:Z

    .line 133
    iput-object v2, p0, Lnb;->G:Landroid/support/v4/app/Fragment;

    .line 134
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lnb;->H:Ljava/util/Map;

    .line 135
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lnb;->I:Ljava/util/HashMap;

    .line 136
    iput-boolean v1, p0, Lnb;->J:Z

    .line 137
    iput-boolean v1, p0, Lnb;->K:Z

    .line 139
    iput-boolean v1, p0, Lnb;->L:Z

    .line 140
    iput-boolean v1, p0, Lnb;->M:Z

    .line 141
    iput-boolean v1, p0, Lnb;->N:Z

    .line 150
    const-string v0, ""

    iput-object v0, p0, Lnb;->i:Ljava/lang/String;

    .line 151
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lnb;->j:Ljava/util/Stack;

    .line 195
    iput-object p1, p0, Lnb;->z:Landroid/content/Context;

    .line 196
    sput-object p0, Lnb;->p:Lnb;

    .line 197
    invoke-direct {p0, p1}, Lnb;->b(Landroid/content/Context;)Ljava/lang/String;

    .line 198
    invoke-direct {p0}, Lnb;->ad()V

    .line 199
    return-void
.end method

.method public static a()Lnb;
    .locals 3

    .prologue
    .line 187
    sget-object v0, Lnb;->p:Lnb;

    if-eqz v0, :cond_0

    .line 188
    sget-object v0, Lnb;->p:Lnb;

    .line 191
    :goto_0
    return-object v0

    .line 190
    :cond_0
    sget-object v0, Lnb;->o:Ljava/lang/String;

    new-instance v1, Ljava/lang/Exception;

    const-string v2, "BBYAppData has not yet been initialized."

    invoke-direct {v1, v2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 191
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Landroid/content/Context;)V
    .locals 5

    .prologue
    .line 173
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    .line 175
    array-length v2, v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-object v3, v1, v0

    .line 176
    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "com.bestbuy.android.base.BBYApplication"

    invoke-virtual {v3, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_1

    .line 178
    sget-object v0, Lnb;->o:Ljava/lang/String;

    const-string v1, "Found correct class!  Setting Instance."

    invoke-static {v0, v1}, Lkf;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    new-instance v0, Lnb;

    invoke-direct {v0, p0}, Lnb;-><init>(Landroid/content/Context;)V

    sput-object v0, Lnb;->p:Lnb;

    .line 183
    :cond_0
    invoke-static {p0}, Llu;->a(Landroid/content/Context;)V

    .line 184
    return-void

    .line 175
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private ad()V
    .locals 3

    .prologue
    .line 356
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    const-string v1, "phone"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .line 358
    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getLine1Number()Ljava/lang/String;

    move-result-object v0

    .line 359
    if-eqz v0, :cond_1

    .line 360
    invoke-static {v0}, Landroid/telephony/PhoneNumberUtils;->stripSeparators(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 361
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0xb

    if-ne v1, v2, :cond_0

    const-string v1, "1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 362
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 364
    :cond_0
    iput-object v0, p0, Lnb;->y:Ljava/lang/String;

    .line 366
    :cond_1
    return-void
.end method

.method private b(Landroid/content/Context;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 274
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 277
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 279
    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v0, p0, Lnb;->P:Ljava/lang/String;

    .line 280
    iget-object v0, p0, Lnb;->P:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 284
    :goto_0
    return-object v0

    .line 281
    :catch_0
    move-exception v0

    .line 282
    sget-object v1, Lnb;->o:Ljava/lang/String;

    invoke-static {v1, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 283
    const-string v0, "Version 1.0"

    iput-object v0, p0, Lnb;->P:Ljava/lang/String;

    .line 284
    iget-object v0, p0, Lnb;->P:Ljava/lang/String;

    goto :goto_0
.end method

.method public static q()Ljava/lang/String;
    .locals 1

    .prologue
    .line 391
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public A()Ljava/lang/String;
    .locals 3

    .prologue
    .line 572
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "APP_STATE"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public B()Ljava/util/ArrayList;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 588
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "RECENTLY_UPDATE_LIST_UUID"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 589
    new-instance v1, Ljava/util/ArrayList;

    const-string v2, "\\s*,\\s*"

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 590
    return-object v1
.end method

.method public C()Z
    .locals 3

    .prologue
    .line 611
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "IS_GIFT_ADDED_TO_LIST"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public D()Ljava/lang/String;
    .locals 3

    .prologue
    .line 619
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "LE_CURRENT_MODULE"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public E()Ljava/lang/Boolean;
    .locals 3

    .prologue
    .line 627
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "IS_REGISTRY_UPDATED"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method public F()Z
    .locals 3

    .prologue
    .line 639
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "is_user_logged_in"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public G()Z
    .locals 3

    .prologue
    .line 647
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "is_ut_cookie_reset"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public H()Z
    .locals 1

    .prologue
    .line 659
    iget-boolean v0, p0, Lnb;->F:Z

    return v0
.end method

.method public I()Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 667
    iget-object v0, p0, Lnb;->G:Landroid/support/v4/app/Fragment;

    return-object v0
.end method

.method public J()Ljava/lang/String;
    .locals 6

    .prologue
    .line 675
    const-string v1, ""

    .line 677
    :try_start_0
    invoke-static {}, Lna;->g()Ljava/util/HashMap;

    move-result-object v2

    .line 678
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 679
    const/16 v3, 0xd

    const v4, 0x28206f

    invoke-virtual {v0, v3, v4}, Ljava/util/Calendar;->add(II)V

    .line 680
    const-string v3, "Expires"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 682
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 683
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 684
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    .line 685
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 686
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    .line 687
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_1
    move-object v1, v0

    .line 689
    goto :goto_0

    .line 690
    :catch_0
    move-exception v0

    .line 691
    const-string v2, "Exception"

    invoke-static {v2, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 693
    :cond_0
    return-object v1

    :cond_1
    move-object v0, v1

    goto :goto_1
.end method

.method public K()Ljava/lang/String;
    .locals 6

    .prologue
    .line 697
    const-string v1, ""

    .line 699
    :try_start_0
    invoke-static {}, Lna;->h()Ljava/util/HashMap;

    move-result-object v2

    .line 700
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 701
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 702
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    .line 703
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 704
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    .line 705
    const-string v5, "Secure"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 706
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_1
    move-object v1, v0

    .line 713
    goto :goto_0

    .line 708
    :cond_0
    const-string v4, "true"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 709
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "Secure;"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_1

    .line 714
    :catch_0
    move-exception v0

    .line 715
    const-string v2, "Exception"

    invoke-static {v2, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 717
    :cond_1
    return-object v1

    :cond_2
    move-object v0, v1

    goto :goto_1
.end method

.method public L()Ljava/lang/String;
    .locals 7

    .prologue
    .line 721
    const-string v1, ""

    .line 723
    :try_start_0
    invoke-static {}, Lna;->c()Ljava/util/HashMap;

    move-result-object v2

    .line 724
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 725
    const/16 v3, 0xd

    const v4, 0x28206f

    invoke-virtual {v0, v3, v4}, Ljava/util/Calendar;->add(II)V

    .line 726
    const-string v3, "Expires"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 727
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 728
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 729
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    .line 730
    const-string v0, "s_app"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 731
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-nez v0, :cond_0

    .line 732
    const-string v0, "s_app"

    invoke-virtual {p0}, Lnb;->p()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 733
    invoke-static {}, Lna;->c()Ljava/util/HashMap;

    move-result-object v0

    const-string v5, "s_app"

    invoke-virtual {p0}, Lnb;->p()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 736
    :cond_0
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 737
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    .line 738
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_1
    move-object v1, v0

    .line 740
    goto :goto_0

    .line 742
    :catch_0
    move-exception v0

    .line 743
    const-string v2, "Exception"

    invoke-static {v2, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 746
    :cond_1
    return-object v1

    :cond_2
    move-object v0, v1

    goto :goto_1
.end method

.method public M()Ljava/lang/String;
    .locals 6

    .prologue
    .line 750
    const-string v1, ""

    .line 752
    :try_start_0
    invoke-static {}, Lna;->d()Ljava/util/HashMap;

    move-result-object v2

    .line 753
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 754
    const/16 v3, 0xd

    const v4, 0x28206f

    invoke-virtual {v0, v3, v4}, Ljava/util/Calendar;->add(II)V

    .line 755
    const-string v3, "Expires"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 756
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 758
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 759
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    .line 760
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 761
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    .line 762
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_1
    move-object v1, v0

    .line 765
    goto :goto_0

    .line 767
    :catch_0
    move-exception v0

    .line 768
    const-string v2, "Exception"

    invoke-static {v2, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 771
    :cond_0
    return-object v1

    :cond_1
    move-object v0, v1

    goto :goto_1
.end method

.method public N()Ljava/lang/String;
    .locals 6

    .prologue
    .line 775
    const-string v1, ""

    .line 777
    :try_start_0
    invoke-static {}, Lna;->e()Ljava/util/HashMap;

    move-result-object v2

    .line 778
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 779
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 780
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    .line 781
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 782
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    .line 783
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_1
    move-object v1, v0

    .line 785
    goto :goto_0

    .line 787
    :catch_0
    move-exception v0

    .line 788
    const-string v2, "Exception"

    invoke-static {v2, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 791
    :cond_0
    return-object v1

    :cond_1
    move-object v0, v1

    goto :goto_1
.end method

.method public O()Ljava/lang/String;
    .locals 6

    .prologue
    .line 795
    const-string v1, ""

    .line 797
    :try_start_0
    invoke-static {}, Lna;->f()Ljava/util/HashMap;

    move-result-object v2

    .line 798
    invoke-interface {v2}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 799
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 800
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    .line 801
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 802
    invoke-interface {v2, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v0

    .line 803
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_1
    move-object v1, v0

    .line 805
    goto :goto_0

    .line 807
    :catch_0
    move-exception v0

    .line 808
    const-string v2, "Exception"

    invoke-static {v2, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 811
    :cond_0
    return-object v1

    :cond_1
    move-object v0, v1

    goto :goto_1
.end method

.method public P()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 815
    iget-object v0, p0, Lnb;->I:Ljava/util/HashMap;

    return-object v0
.end method

.method public Q()Z
    .locals 1

    .prologue
    .line 823
    iget-boolean v0, p0, Lnb;->J:Z

    return v0
.end method

.method public R()Z
    .locals 1

    .prologue
    .line 831
    iget-boolean v0, p0, Lnb;->K:Z

    return v0
.end method

.method public S()Ljava/lang/String;
    .locals 1

    .prologue
    .line 865
    iget-object v0, p0, Lnb;->i:Ljava/lang/String;

    return-object v0
.end method

.method public T()Ljava/lang/String;
    .locals 2

    .prologue
    .line 877
    iget-object v0, p0, Lnb;->j:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 878
    iget-object v0, p0, Lnb;->j:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 879
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lnb;->j:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public U()Ljava/util/Stack;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Stack",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 883
    iget-object v0, p0, Lnb;->j:Ljava/util/Stack;

    return-object v0
.end method

.method public V()Z
    .locals 1

    .prologue
    .line 890
    iget-boolean v0, p0, Lnb;->L:Z

    return v0
.end method

.method public W()Z
    .locals 1

    .prologue
    .line 905
    iget-boolean v0, p0, Lnb;->N:Z

    return v0
.end method

.method public X()Z
    .locals 1

    .prologue
    .line 920
    iget-boolean v0, p0, Lnb;->M:Z

    return v0
.end method

.method public Y()Ljava/lang/String;
    .locals 1

    .prologue
    .line 936
    iget-object v0, p0, Lnb;->Q:Ljava/lang/String;

    return-object v0
.end method

.method public Z()Z
    .locals 1

    .prologue
    .line 943
    iget-boolean v0, p0, Lnb;->O:Z

    return v0
.end method

.method public a(I)F
    .locals 2

    .prologue
    .line 471
    int-to-float v0, p1

    const/high16 v1, 0x43a00000    # 320.0f

    div-float/2addr v0, v1

    invoke-virtual {p0}, Lnb;->u()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v0, v1

    iput v0, p0, Lnb;->r:F

    .line 472
    iget v0, p0, Lnb;->r:F

    return v0
.end method

.method public a(D)V
    .locals 1

    .prologue
    .line 560
    iput-wide p1, p0, Lnb;->D:D

    .line 561
    return-void
.end method

.method public a(Landroid/support/v4/app/Fragment;)V
    .locals 0

    .prologue
    .line 671
    iput-object p1, p0, Lnb;->G:Landroid/support/v4/app/Fragment;

    .line 672
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 431
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080041

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 432
    return-void
.end method

.method public a(Ljava/lang/String;Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 984
    invoke-static {}, Lgw;->a()Lorg/apache/http/impl/client/DefaultHttpClient;

    move-result-object v0

    .line 985
    invoke-virtual {v0}, Lorg/apache/http/impl/client/DefaultHttpClient;->getCookieStore()Lorg/apache/http/client/CookieStore;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/client/CookieStore;->clear()V

    .line 986
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    .line 987
    invoke-virtual {v0}, Landroid/webkit/CookieManager;->removeAllCookie()V

    .line 988
    invoke-virtual {v0}, Landroid/webkit/CookieManager;->removeSessionCookie()V

    .line 989
    invoke-static {p2}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 990
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 991
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 603
    const-string v0, ""

    .line 604
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move-object v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 605
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, ","

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 606
    goto :goto_0

    .line 607
    :cond_0
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v2, "RECENTLY_UPDATE_LIST_UUID"

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 608
    return-void
.end method

.method public a(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 819
    iget-object v0, p0, Lnb;->I:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 820
    return-void
.end method

.method public a(Lmr;)V
    .locals 0

    .prologue
    .line 528
    iput-object p1, p0, Lnb;->A:Lmr;

    .line 529
    return-void
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 544
    sput-boolean p1, Lnb;->C:Z

    .line 545
    return-void
.end method

.method public aa()Z
    .locals 1

    .prologue
    .line 954
    iget-boolean v0, p0, Lnb;->R:Z

    return v0
.end method

.method public ab()Ljava/lang/String;
    .locals 1

    .prologue
    .line 973
    iget-object v0, p0, Lnb;->S:Ljava/lang/String;

    return-object v0
.end method

.method public ac()Z
    .locals 3

    .prologue
    .line 994
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080061

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public b(I)F
    .locals 2

    .prologue
    .line 476
    int-to-float v0, p1

    const/high16 v1, 0x43f00000    # 480.0f

    div-float/2addr v0, v1

    invoke-virtual {p0}, Lnb;->v()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v0, v1

    iput v0, p0, Lnb;->s:F

    .line 477
    iget v0, p0, Lnb;->s:F

    return v0
.end method

.method public b()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 202
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08007f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method public b(D)V
    .locals 1

    .prologue
    .line 568
    iput-wide p1, p0, Lnb;->E:D

    .line 569
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 439
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080042

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 444
    return-void
.end method

.method public b(Z)V
    .locals 2

    .prologue
    .line 615
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "IS_GIFT_ADDED_TO_LIST"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 616
    return-void
.end method

.method public c()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 206
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08007e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method public c(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 576
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "APP_STATE"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 577
    return-void
.end method

.method public c(Z)V
    .locals 2

    .prologue
    .line 631
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "IS_REGISTRY_UPDATED"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 632
    return-void
.end method

.method public d()Ljava/lang/String;
    .locals 2

    .prologue
    .line 218
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080153

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public d(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 584
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "LAST_LOGIN_EMAIL_ID"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 585
    return-void
.end method

.method public d(Z)V
    .locals 2

    .prologue
    .line 635
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "is_user_logged_in"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 636
    return-void
.end method

.method public e()Ljava/lang/String;
    .locals 2

    .prologue
    .line 222
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0802b3

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public e(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 594
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "RECENTLY_UPDATE_LIST_UUID"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 595
    new-instance v1, Ljava/util/ArrayList;

    const-string v2, "\\s*,\\s*"

    invoke-virtual {v0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 596
    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 597
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 598
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "RECENTLY_UPDATE_LIST_UUID"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 600
    :cond_0
    return-void
.end method

.method public e(Z)V
    .locals 2

    .prologue
    .line 643
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "is_ut_cookie_reset"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 644
    return-void
.end method

.method public f()Ljava/lang/String;
    .locals 2

    .prologue
    .line 226
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0800df

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public f(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 623
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "LE_CURRENT_MODULE"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 624
    return-void
.end method

.method public f(Z)V
    .locals 2

    .prologue
    .line 651
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "refresh_mybby"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 652
    return-void
.end method

.method public g()Ljava/lang/String;
    .locals 2

    .prologue
    .line 230
    invoke-static {}, Lna;->b()Lft;

    move-result-object v0

    .line 231
    sget-object v1, Lft;->a:Lft;

    if-ne v0, v1, :cond_0

    .line 232
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08031e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 242
    :goto_0
    return-object v0

    .line 233
    :cond_0
    sget-object v1, Lft;->e:Lft;

    if-ne v0, v1, :cond_1

    .line 234
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080323

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 235
    :cond_1
    sget-object v1, Lft;->h:Lft;

    if-ne v0, v1, :cond_2

    .line 236
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080321

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 237
    :cond_2
    sget-object v1, Lft;->d:Lft;

    if-ne v0, v1, :cond_3

    .line 238
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080325

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 239
    :cond_3
    sget-object v1, Lft;->i:Lft;

    if-ne v0, v1, :cond_4

    .line 240
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08031c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 242
    :cond_4
    const-string v0, ""

    goto :goto_0
.end method

.method public g(Ljava/lang/String;)Ljava/lang/String;
    .locals 7

    .prologue
    .line 839
    const-string v0, ""

    .line 840
    iget-object v1, p0, Lnb;->H:Ljava/util/Map;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lnb;->H:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 842
    :cond_0
    :try_start_0
    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    const-string v2, "colorcodes.json"

    invoke-virtual {v1, v2}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 843
    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 844
    invoke-static {v1, v2}, Lgw;->a(Ljava/io/InputStream;Ljava/io/OutputStream;)V

    .line 845
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V

    .line 846
    new-instance v1, Ljava/lang/String;

    invoke-virtual {v2}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>([B)V

    .line 847
    new-instance v2, Lorg/json/JSONArray;

    invoke-direct {v2, v1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 848
    const/4 v1, 0x0

    :goto_0
    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-ge v1, v3, :cond_2

    .line 849
    invoke-virtual {v2, v1}, Lorg/json/JSONArray;->optJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 850
    if-eqz v3, :cond_1

    .line 851
    iget-object v4, p0, Lnb;->H:Ljava/util/Map;

    const-string v5, "colorname"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "colorcode"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 848
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 854
    :catch_0
    move-exception v1

    .line 855
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 858
    :cond_2
    iget-object v1, p0, Lnb;->H:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_3

    .line 859
    iget-object v0, p0, Lnb;->H:Ljava/util/Map;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 861
    :cond_3
    return-object v0
.end method

.method public g(Z)V
    .locals 0

    .prologue
    .line 663
    iput-boolean p1, p0, Lnb;->F:Z

    .line 664
    return-void
.end method

.method public h()Ljava/lang/String;
    .locals 2

    .prologue
    .line 246
    invoke-static {}, Lna;->a()Lft;

    move-result-object v0

    .line 247
    sget-object v1, Lft;->a:Lft;

    if-ne v0, v1, :cond_0

    .line 248
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080320

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 258
    :goto_0
    return-object v0

    .line 249
    :cond_0
    sget-object v1, Lft;->e:Lft;

    if-ne v0, v1, :cond_1

    .line 250
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080324

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 251
    :cond_1
    sget-object v1, Lft;->h:Lft;

    if-ne v0, v1, :cond_2

    .line 252
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080322

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 253
    :cond_2
    sget-object v1, Lft;->d:Lft;

    if-ne v0, v1, :cond_3

    .line 254
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080326

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 255
    :cond_3
    sget-object v1, Lft;->i:Lft;

    if-ne v0, v1, :cond_4

    .line 256
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08031d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 258
    :cond_4
    const-string v0, ""

    goto :goto_0
.end method

.method public h(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 869
    iput-object p1, p0, Lnb;->i:Ljava/lang/String;

    .line 870
    return-void
.end method

.method public h(Z)V
    .locals 0

    .prologue
    .line 827
    iput-boolean p1, p0, Lnb;->J:Z

    .line 828
    return-void
.end method

.method public i()Ljava/lang/String;
    .locals 2

    .prologue
    .line 262
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08021c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public i(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 873
    iget-object v0, p0, Lnb;->j:Ljava/util/Stack;

    invoke-virtual {v0, p1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 874
    return-void
.end method

.method public i(Z)V
    .locals 0

    .prologue
    .line 835
    iput-boolean p1, p0, Lnb;->K:Z

    .line 836
    return-void
.end method

.method public j()Ljava/lang/String;
    .locals 2

    .prologue
    .line 266
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0801b2

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public j(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 932
    iput-object p1, p0, Lnb;->Q:Ljava/lang/String;

    .line 933
    return-void
.end method

.method public j(Z)V
    .locals 0

    .prologue
    .line 898
    iput-boolean p1, p0, Lnb;->L:Z

    .line 899
    return-void
.end method

.method public k()Ljava/lang/String;
    .locals 2

    .prologue
    .line 270
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080253

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public k(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 980
    iput-object p1, p0, Lnb;->S:Ljava/lang/String;

    .line 981
    return-void
.end method

.method public k(Z)V
    .locals 0

    .prologue
    .line 913
    iput-boolean p1, p0, Lnb;->N:Z

    .line 914
    return-void
.end method

.method public l()Ljava/lang/String;
    .locals 1

    .prologue
    .line 289
    iget-object v0, p0, Lnb;->P:Ljava/lang/String;

    return-object v0
.end method

.method public l(Z)V
    .locals 0

    .prologue
    .line 928
    iput-boolean p1, p0, Lnb;->M:Z

    .line 929
    return-void
.end method

.method public m()Ljava/lang/String;
    .locals 1

    .prologue
    .line 293
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    return-object v0
.end method

.method public m(Z)V
    .locals 0

    .prologue
    .line 950
    iput-boolean p1, p0, Lnb;->O:Z

    .line 951
    return-void
.end method

.method public n()Llr;
    .locals 1

    .prologue
    .line 328
    iget-object v0, p0, Lnb;->b:Llr;

    if-nez v0, :cond_0

    .line 329
    new-instance v0, Llr;

    invoke-direct {v0}, Llr;-><init>()V

    iput-object v0, p0, Lnb;->b:Llr;

    .line 331
    :cond_0
    iget-object v0, p0, Lnb;->b:Llr;

    return-object v0
.end method

.method public n(Z)V
    .locals 0

    .prologue
    .line 958
    iput-boolean p1, p0, Lnb;->R:Z

    .line 959
    return-void
.end method

.method public o()Ljava/util/HashMap;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 335
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 336
    iget-object v1, p0, Lnb;->a:Ljava/util/Map;

    if-eqz v1, :cond_0

    .line 337
    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08005c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 339
    iget-object v2, p0, Lnb;->a:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 341
    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08005e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 343
    iget-object v2, p0, Lnb;->a:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 345
    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08005d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 347
    iget-object v2, p0, Lnb;->a:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 349
    :cond_0
    return-object v0
.end method

.method public o(Z)V
    .locals 3

    .prologue
    .line 998
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080061

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 999
    return-void
.end method

.method public p()Ljava/lang/String;
    .locals 2

    .prologue
    .line 373
    const-string v0, ""

    .line 374
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    const-string v1, "phone"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .line 375
    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    .line 376
    return-object v0
.end method

.method public r()Ljava/lang/String;
    .locals 2

    .prologue
    .line 396
    invoke-static {}, Lcom/adobe/mobile/Config;->getUserIdentifier()Ljava/lang/String;

    move-result-object v0

    .line 398
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-gtz v1, :cond_1

    .line 400
    :cond_0
    invoke-static {}, Lcom/adobe/mobile/Analytics;->getTrackingIdentifier()Ljava/lang/String;

    move-result-object v0

    .line 402
    :cond_1
    return-object v0
.end method

.method public s()Ljava/lang/String;
    .locals 3

    .prologue
    .line 447
    invoke-virtual {p0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    iget-object v1, p0, Lnb;->z:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080042

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public t()Landroid/view/Display;
    .locals 2

    .prologue
    .line 455
    iget-object v0, p0, Lnb;->x:Landroid/view/Display;

    if-nez v0, :cond_0

    .line 456
    iget-object v0, p0, Lnb;->z:Landroid/content/Context;

    const-string v1, "window"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    .line 458
    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    iput-object v0, p0, Lnb;->x:Landroid/view/Display;

    .line 460
    :cond_0
    iget-object v0, p0, Lnb;->x:Landroid/view/Display;

    return-object v0
.end method

.method public u()I
    .locals 3

    .prologue
    .line 481
    iget v0, p0, Lnb;->t:I

    if-nez v0, :cond_0

    .line 482
    invoke-virtual {p0}, Lnb;->t()Landroid/view/Display;

    move-result-object v0

    .line 483
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xe

    if-lt v1, v2, :cond_1

    .line 484
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    .line 485
    invoke-virtual {v0, v1}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 486
    iget v0, v1, Landroid/graphics/Point;->x:I

    iput v0, p0, Lnb;->t:I

    .line 491
    :cond_0
    :goto_0
    iget v0, p0, Lnb;->t:I

    return v0

    .line 488
    :cond_1
    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v0

    iput v0, p0, Lnb;->t:I

    goto :goto_0
.end method

.method public v()I
    .locals 3

    .prologue
    .line 495
    iget v0, p0, Lnb;->u:I

    if-nez v0, :cond_0

    .line 496
    invoke-virtual {p0}, Lnb;->t()Landroid/view/Display;

    move-result-object v0

    .line 497
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xe

    if-lt v1, v2, :cond_1

    .line 498
    new-instance v1, Landroid/graphics/Point;

    invoke-direct {v1}, Landroid/graphics/Point;-><init>()V

    .line 499
    invoke-virtual {v0, v1}, Landroid/view/Display;->getSize(Landroid/graphics/Point;)V

    .line 500
    iget v0, v1, Landroid/graphics/Point;->y:I

    iput v0, p0, Lnb;->u:I

    .line 505
    :cond_0
    :goto_0
    iget v0, p0, Lnb;->u:I

    return v0

    .line 502
    :cond_1
    invoke-virtual {v0}, Landroid/view/Display;->getHeight()I

    move-result v0

    iput v0, p0, Lnb;->u:I

    goto :goto_0
.end method

.method public w()Lmr;
    .locals 1

    .prologue
    .line 519
    iget-object v0, p0, Lnb;->A:Lmr;

    if-eqz v0, :cond_0

    .line 520
    iget-object v0, p0, Lnb;->A:Lmr;

    .line 523
    :goto_0
    return-object v0

    .line 522
    :cond_0
    new-instance v0, Lmr;

    invoke-direct {v0}, Lmr;-><init>()V

    iput-object v0, p0, Lnb;->A:Lmr;

    .line 523
    iget-object v0, p0, Lnb;->A:Lmr;

    goto :goto_0
.end method

.method public x()Z
    .locals 1

    .prologue
    .line 540
    sget-boolean v0, Lnb;->C:Z

    return v0
.end method

.method public y()D
    .locals 2

    .prologue
    .line 556
    iget-wide v0, p0, Lnb;->D:D

    return-wide v0
.end method

.method public z()D
    .locals 2

    .prologue
    .line 564
    iget-wide v0, p0, Lnb;->E:D

    return-wide v0
.end method
