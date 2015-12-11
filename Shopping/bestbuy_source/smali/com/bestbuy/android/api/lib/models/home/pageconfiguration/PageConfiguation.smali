.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private analyticsPageType:Ljava/lang/String;

.field private krakenNodeConfigVersion:Ljava/lang/String;

.field private layoutName:Ljava/lang/String;

.field private pageTitle:Ljava/lang/String;

.field private rowContainer:Z

.field private shortName:Ljava/lang/String;

.field private widgets:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAnalyticsPageType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->analyticsPageType:Ljava/lang/String;

    return-object v0
.end method

.method public getKrakenNodeConfigVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->krakenNodeConfigVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getLayoutName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->layoutName:Ljava/lang/String;

    return-object v0
.end method

.method public getPageTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->pageTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getShortName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->shortName:Ljava/lang/String;

    return-object v0
.end method

.method public getWidgets()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;",
            ">;"
        }
    .end annotation

    .prologue
    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->widgets:Ljava/util/List;

    return-object v0
.end method

.method public isRowContainer()Z
    .locals 1

    .prologue
    .line 55
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->rowContainer:Z

    return v0
.end method

.method public setAnalyticsPageType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->analyticsPageType:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public setKrakenNodeConfigVersion(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->krakenNodeConfigVersion:Ljava/lang/String;

    .line 75
    return-void
.end method

.method public setLayoutName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 80
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->layoutName:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setPageTitle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->pageTitle:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setRowContainer(Z)V
    .locals 0

    .prologue
    .line 92
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->rowContainer:Z

    .line 93
    return-void
.end method

.method public setShortName(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->shortName:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setWidgets(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 111
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/PageConfiguation;->widgets:Ljava/util/List;

    .line 112
    return-void
.end method
