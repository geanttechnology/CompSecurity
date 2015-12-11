.class public Lln;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lmt;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lln;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lln;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "envsettings.json"

    invoke-virtual {v0, v1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    .line 28
    invoke-static {v0}, Lni;->a(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    .line 29
    new-instance v1, Lms;

    invoke-direct {v1, v0}, Lms;-><init>(Ljava/lang/String;)V

    .line 30
    invoke-virtual {v1}, Lms;->a()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lln;->b:Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 34
    :goto_0
    return-void

    .line 31
    :catch_0
    move-exception v0

    .line 32
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method private a(Ljava/lang/String;)Lmt;
    .locals 3

    .prologue
    .line 158
    iget-object v0, p0, Lln;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmt;

    .line 159
    invoke-virtual {v0}, Lmt;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v2

    if-nez v2, :cond_0

    .line 163
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a()Lft;
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 37
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 38
    const-string v1, ""

    .line 39
    const-string v1, "SI"

    invoke-direct {p0, v1}, Lln;->a(Ljava/lang/String;)Lmt;

    move-result-object v1

    .line 40
    const-string v2, "SI"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 41
    if-eq v0, v3, :cond_0

    .line 42
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 47
    :goto_0
    const-string v1, "Production"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_1

    .line 48
    sget-object v0, Lft;->a:Lft;

    .line 54
    :goto_1
    return-object v0

    .line 44
    :cond_0
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v1}, Lmt;->d()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0

    .line 49
    :cond_1
    const-string v1, "QA1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_2

    .line 50
    sget-object v0, Lft;->f:Lft;

    goto :goto_1

    .line 51
    :cond_2
    const-string v1, "Stage"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_3

    .line 52
    sget-object v0, Lft;->d:Lft;

    goto :goto_1

    .line 54
    :cond_3
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public b()Lft;
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 58
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 59
    const-string v1, ""

    .line 60
    const-string v1, "CartManager"

    invoke-direct {p0, v1}, Lln;->a(Ljava/lang/String;)Lmt;

    move-result-object v1

    .line 61
    const-string v2, "CartManager"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 62
    if-eq v0, v3, :cond_0

    .line 63
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 67
    :goto_0
    const-string v1, "Production"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_1

    .line 68
    sget-object v0, Lft;->a:Lft;

    .line 78
    :goto_1
    return-object v0

    .line 65
    :cond_0
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v1}, Lmt;->d()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0

    .line 69
    :cond_1
    const-string v1, "QA1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_2

    .line 70
    sget-object v0, Lft;->f:Lft;

    goto :goto_1

    .line 71
    :cond_2
    const-string v1, "QA3"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_3

    .line 72
    sget-object v0, Lft;->h:Lft;

    goto :goto_1

    .line 73
    :cond_3
    const-string v1, "CDC"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_4

    .line 74
    sget-object v0, Lft;->i:Lft;

    goto :goto_1

    .line 75
    :cond_4
    const-string v1, "Stage"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_5

    .line 76
    sget-object v0, Lft;->d:Lft;

    goto :goto_1

    .line 78
    :cond_5
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public c()Lft;
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 82
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 83
    const-string v1, ""

    .line 84
    const-string v1, "Deals"

    invoke-direct {p0, v1}, Lln;->a(Ljava/lang/String;)Lmt;

    move-result-object v1

    .line 85
    const-string v2, "Deals"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 86
    if-eq v0, v3, :cond_0

    .line 87
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 92
    :goto_0
    const-string v1, "Production"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_1

    .line 93
    sget-object v0, Lft;->a:Lft;

    .line 99
    :goto_1
    return-object v0

    .line 89
    :cond_0
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v1}, Lmt;->d()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0

    .line 94
    :cond_1
    const-string v1, "QA1"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_2

    .line 95
    sget-object v0, Lft;->f:Lft;

    goto :goto_1

    .line 96
    :cond_2
    const-string v1, "Prod Like"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_3

    .line 97
    sget-object v0, Lft;->b:Lft;

    goto :goto_1

    .line 99
    :cond_3
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public d()Lft;
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 103
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 104
    const-string v1, ""

    .line 105
    const-string v1, "Experience Platform"

    invoke-direct {p0, v1}, Lln;->a(Ljava/lang/String;)Lmt;

    move-result-object v1

    .line 106
    const-string v2, "Experience Platform"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 107
    if-eq v0, v3, :cond_0

    .line 108
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 112
    :goto_0
    const-string v1, "Production"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_1

    .line 113
    sget-object v0, Lft;->a:Lft;

    .line 121
    :goto_1
    return-object v0

    .line 110
    :cond_0
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v1}, Lmt;->d()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0

    .line 114
    :cond_1
    const-string v1, "QA"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_2

    .line 115
    sget-object v0, Lft;->e:Lft;

    goto :goto_1

    .line 116
    :cond_2
    const-string v1, "QA3"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_3

    .line 117
    sget-object v0, Lft;->h:Lft;

    goto :goto_1

    .line 118
    :cond_3
    const-string v1, "Prod Like"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_4

    .line 119
    sget-object v0, Lft;->b:Lft;

    goto :goto_1

    .line 121
    :cond_4
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public e()Lft;
    .locals 4

    .prologue
    const/4 v3, -0x1

    .line 130
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 131
    const-string v1, ""

    .line 132
    const-string v1, "Offers"

    invoke-direct {p0, v1}, Lln;->a(Ljava/lang/String;)Lmt;

    move-result-object v1

    .line 133
    const-string v2, "Offers"

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 134
    if-eq v0, v3, :cond_0

    .line 135
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 140
    :goto_0
    const-string v1, "Production"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_1

    .line 141
    sget-object v0, Lft;->a:Lft;

    .line 146
    :goto_1
    return-object v0

    .line 137
    :cond_0
    invoke-virtual {v1}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v1}, Lmt;->d()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0

    .line 142
    :cond_1
    const-string v1, "QA"

    invoke-virtual {v0, v1}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_2

    .line 143
    sget-object v0, Lft;->e:Lft;

    goto :goto_1

    .line 146
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method
