.class public Llr;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Ljava/lang/String;

.field private c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 16
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v0

    const/4 v1, 0x2

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Llr;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 118
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;)Z
    .locals 6

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 41
    iget-object v2, p0, Llr;->c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    if-eqz v2, :cond_2

    iget-object v2, p0, Llr;->c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getType()I

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Llr;->c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getSi()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Llr;->c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getSi()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->getResponse()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Llr;->c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getSi()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->getResponse()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->getCurrentVersion()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Llr;->c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getSi()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->getResponse()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->getCurrentVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080068

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 45
    :try_start_0
    iget-object v2, p0, Llr;->c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getType()I

    move-result v2

    const/16 v3, 0x64

    if-ne v2, v3, :cond_0

    .line 46
    new-instance v2, Lnt;

    iget-object v3, p0, Llr;->c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getSi()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->getResponse()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->getCurrentVersion()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lnt;-><init>(Ljava/lang/String;)V

    .line 47
    invoke-virtual {p1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    iget-object v3, v3, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v3, p0, Llr;->b:Ljava/lang/String;

    .line 49
    sget-object v3, Llr;->a:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "localVersionText-"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Llr;->b:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    new-instance v3, Lnt;

    iget-object v4, p0, Llr;->b:Ljava/lang/String;

    invoke-direct {v3, v4}, Lnt;-><init>(Ljava/lang/String;)V

    .line 52
    invoke-virtual {v2, v3}, Lnt;->a(Lnt;)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    if-eqz v2, :cond_1

    .line 65
    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    .line 55
    goto :goto_0

    .line 60
    :catch_0
    move-exception v0

    .line 61
    sget-object v2, Llr;->a:Ljava/lang/String;

    invoke-static {v2, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    move v0, v1

    .line 62
    goto :goto_0

    :cond_2
    move v0, v1

    .line 65
    goto :goto_0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;Landroid/content/Context;)Z
    .locals 1

    .prologue
    .line 36
    iput-object p1, p0, Llr;->c:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    .line 37
    invoke-virtual {p0, p2}, Llr;->a(Landroid/content/Context;)Z

    move-result v0

    return v0
.end method

.method public b(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;Landroid/content/Context;)Z
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 71
    if-eqz p1, :cond_0

    .line 72
    :try_start_0
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getSi()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    move-result-object v1

    .line 73
    if-eqz v1, :cond_0

    .line 74
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->getResponse()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

    move-result-object v1

    .line 75
    if-eqz v1, :cond_0

    .line 76
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->getMinimumSupportedVersion()Ljava/lang/String;

    move-result-object v1

    .line 77
    new-instance v2, Lnt;

    invoke-direct {v2, v1}, Lnt;-><init>(Ljava/lang/String;)V

    .line 79
    invoke-virtual {p2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v1, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget-object v1, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v1, p0, Llr;->b:Ljava/lang/String;

    .line 80
    new-instance v1, Lnt;

    iget-object v3, p0, Llr;->b:Ljava/lang/String;

    invoke-direct {v1, v3}, Lnt;-><init>(Ljava/lang/String;)V

    .line 82
    invoke-virtual {v2, v1}, Lnt;->a(Lnt;)Z
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-eqz v1, :cond_0

    .line 83
    const/4 v0, 0x1

    .line 95
    :cond_0
    :goto_0
    return v0

    .line 91
    :catch_0
    move-exception v1

    .line 92
    sget-object v2, Llr;->a:Ljava/lang/String;

    invoke-static {v2, v1}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public c(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;Landroid/content/Context;)Llc;
    .locals 5

    .prologue
    .line 100
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getType()I

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getStoreLink()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 101
    new-instance v0, Llc;

    const-string v1, "New Version Available"

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getSi()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->getResponse()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->getCurrentVersionMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, p2, v1, v2}, Llc;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getStoreLink()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Llc;->a(Ljava/lang/String;)V

    .line 103
    iget-object v1, p0, Llr;->b:Ljava/lang/String;

    if-nez v1, :cond_0

    .line 105
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget-object v1, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v1, p0, Llr;->b:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 111
    :cond_0
    :goto_0
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getUpdateButtonTitle()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Llr;->b:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;->getSi()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsParent;->getResponse()Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVserionsData;->getCurrentVersion()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Llc;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    :goto_1
    return-object v0

    .line 106
    :catch_0
    move-exception v1

    .line 107
    const-string v2, "unknown"

    iput-object v2, p0, Llr;->b:Ljava/lang/String;

    .line 108
    sget-object v2, Llr;->a:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not get local version: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Landroid/content/pm/PackageManager$NameNotFoundException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 114
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method
