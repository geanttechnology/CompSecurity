.class public Lna;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Z

.field public static b:Z

.field private static c:Lna;

.field private static f:Lft;

.field private static g:Lft;

.field private static h:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static i:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static j:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static k:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static l:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private d:Landroid/content/Context;

.field private e:Lnb;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 28
    sput-boolean v0, Lna;->a:Z

    .line 29
    sput-boolean v0, Lna;->b:Z

    .line 34
    sget-object v0, Lft;->a:Lft;

    sput-object v0, Lna;->f:Lft;

    .line 35
    sget-object v0, Lft;->a:Lft;

    sput-object v0, Lna;->g:Lft;

    .line 37
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    sput-object v0, Lna;->h:Ljava/util/LinkedHashMap;

    .line 38
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    sput-object v0, Lna;->i:Ljava/util/LinkedHashMap;

    .line 39
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    sput-object v0, Lna;->j:Ljava/util/LinkedHashMap;

    .line 40
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    sput-object v0, Lna;->k:Ljava/util/LinkedHashMap;

    .line 41
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    sput-object v0, Lna;->l:Ljava/util/LinkedHashMap;

    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    iput-object p1, p0, Lna;->d:Landroid/content/Context;

    .line 49
    new-instance v0, Lnb;

    invoke-direct {v0, p1}, Lnb;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lna;->e:Lnb;

    .line 50
    sput-object p0, Lna;->c:Lna;

    .line 51
    new-instance v0, Lln;

    invoke-direct {v0, p1}, Lln;-><init>(Landroid/content/Context;)V

    .line 52
    invoke-virtual {v0}, Lln;->e()Lft;

    move-result-object v1

    invoke-static {v1}, Lgm;->a(Lft;)V

    .line 53
    invoke-virtual {v0}, Lln;->a()Lft;

    move-result-object v1

    invoke-static {v1}, Lgq;->a(Lft;)V

    .line 54
    invoke-virtual {v0}, Lln;->c()Lft;

    move-result-object v1

    invoke-static {v1}, Lgd;->a(Lft;)V

    .line 55
    invoke-virtual {v0}, Lln;->d()Lft;

    move-result-object v1

    invoke-static {v1}, Lgg;->a(Lft;)V

    .line 56
    invoke-virtual {v0}, Lln;->b()Lft;

    move-result-object v0

    invoke-static {v0}, Lga;->a(Lft;)V

    .line 57
    invoke-direct {p0}, Lna;->i()V

    .line 58
    return-void
.end method

.method public static a()Lft;
    .locals 1

    .prologue
    .line 120
    sget-object v0, Lna;->g:Lft;

    return-object v0
.end method

.method public static a(Landroid/content/Context;)V
    .locals 5

    .prologue
    .line 66
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    .line 67
    array-length v2, v1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v2, :cond_0

    aget-object v3, v1, v0

    .line 68
    invoke-virtual {v3}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "com.bestbuy.android.base.BBYApplication"

    invoke-virtual {v3, v4}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v3

    if-nez v3, :cond_1

    .line 69
    const-string v0, "BBYAppConfig"

    const-string v1, "Found correct class!  Setting Instance."

    invoke-static {v0, v1}, Lkf;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    new-instance v0, Lna;

    invoke-direct {v0, p0}, Lna;-><init>(Landroid/content/Context;)V

    sput-object v0, Lna;->c:Lna;

    .line 74
    :cond_0
    return-void

    .line 67
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public static a(Lft;)V
    .locals 0

    .prologue
    .line 116
    sput-object p0, Lna;->g:Lft;

    .line 117
    return-void
.end method

.method public static b()Lft;
    .locals 1

    .prologue
    .line 128
    sget-object v0, Lna;->f:Lft;

    return-object v0
.end method

.method public static b(Lft;)V
    .locals 0

    .prologue
    .line 124
    sput-object p0, Lna;->f:Lft;

    .line 125
    return-void
.end method

.method public static c()Ljava/util/HashMap;
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
    .line 153
    sget-object v0, Lna;->h:Ljava/util/LinkedHashMap;

    return-object v0
.end method

.method public static d()Ljava/util/HashMap;
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
    .line 157
    sget-object v0, Lna;->i:Ljava/util/LinkedHashMap;

    return-object v0
.end method

.method public static e()Ljava/util/HashMap;
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
    .line 165
    sget-object v0, Lna;->k:Ljava/util/LinkedHashMap;

    return-object v0
.end method

.method public static f()Ljava/util/HashMap;
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
    .line 169
    sget-object v0, Lna;->l:Ljava/util/LinkedHashMap;

    return-object v0
.end method

.method public static g()Ljava/util/HashMap;
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
    .line 173
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    .line 174
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 175
    const-string v1, "ut"

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 176
    const-string v1, "Domain"

    const-string v2, ".bestbuy.com"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    const-string v1, "Path"

    const-string v2, "/"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 178
    const-string v1, "Version"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    :cond_0
    return-object v0
.end method

.method public static h()Ljava/util/HashMap;
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
    .line 184
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    .line 185
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 186
    const-string v1, "at"

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 187
    const-string v1, "Domain"

    const-string v2, ".bestbuy.com"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 188
    const-string v1, "Path"

    const-string v2, "/"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 189
    const-string v1, "Version"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 190
    const-string v1, "Secure"

    const-string v2, "true"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 192
    :cond_0
    return-object v0
.end method

.method private i()V
    .locals 4

    .prologue
    .line 87
    iget-object v0, p0, Lna;->e:Lnb;

    invoke-virtual {v0}, Lnb;->p()Ljava/lang/String;

    move-result-object v0

    .line 88
    iget-object v1, p0, Lna;->e:Lnb;

    invoke-virtual {v1}, Lnb;->r()Ljava/lang/String;

    move-result-object v1

    .line 89
    sget-object v2, Lna;->h:Ljava/util/LinkedHashMap;

    const-string v3, "s_app"

    invoke-virtual {v2, v3, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 90
    sget-object v0, Lna;->h:Ljava/util/LinkedHashMap;

    const-string v2, "Domain"

    const-string v3, ".bestbuy.com"

    invoke-virtual {v0, v2, v3}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 91
    sget-object v0, Lna;->h:Ljava/util/LinkedHashMap;

    const-string v2, "Path"

    const-string v3, "/"

    invoke-virtual {v0, v2, v3}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    sget-object v0, Lna;->h:Ljava/util/LinkedHashMap;

    const-string v2, "Version"

    const-string v3, "0"

    invoke-virtual {v0, v2, v3}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    sget-object v0, Lna;->j:Ljava/util/LinkedHashMap;

    const-string v2, "s_vi"

    invoke-virtual {v0, v2, v1}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    sget-object v0, Lna;->j:Ljava/util/LinkedHashMap;

    const-string v1, "Domain"

    const-string v2, ".bestbuy.com"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    sget-object v0, Lna;->j:Ljava/util/LinkedHashMap;

    const-string v1, "Path"

    const-string v2, "/"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 97
    sget-object v0, Lna;->j:Ljava/util/LinkedHashMap;

    const-string v1, "Version"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 99
    sget-object v0, Lna;->i:Ljava/util/LinkedHashMap;

    const-string v1, "s_channel"

    const-string v2, "mapp-android"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    sget-object v0, Lna;->i:Ljava/util/LinkedHashMap;

    const-string v1, "Domain"

    const-string v2, ".bestbuy.com"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    sget-object v0, Lna;->i:Ljava/util/LinkedHashMap;

    const-string v1, "Path"

    const-string v2, "/"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    sget-object v0, Lna;->i:Ljava/util/LinkedHashMap;

    const-string v1, "Version"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    sget-object v0, Lna;->k:Ljava/util/LinkedHashMap;

    const-string v1, "bby_rdp"

    const-string v2, "s"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 105
    sget-object v0, Lna;->k:Ljava/util/LinkedHashMap;

    const-string v1, "Domain"

    const-string v2, ".bestbuy.com"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 106
    sget-object v0, Lna;->k:Ljava/util/LinkedHashMap;

    const-string v1, "Path"

    const-string v2, "/"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 107
    sget-object v0, Lna;->k:Ljava/util/LinkedHashMap;

    const-string v1, "Version"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    sget-object v0, Lna;->l:Ljava/util/LinkedHashMap;

    const-string v1, "com_ress"

    const-string v2, "true"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 110
    sget-object v0, Lna;->l:Ljava/util/LinkedHashMap;

    const-string v1, "Domain"

    const-string v2, ".bestbuy.com"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 111
    sget-object v0, Lna;->l:Ljava/util/LinkedHashMap;

    const-string v1, "Path"

    const-string v2, "/"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    sget-object v0, Lna;->l:Ljava/util/LinkedHashMap;

    const-string v1, "Version"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 113
    return-void
.end method
