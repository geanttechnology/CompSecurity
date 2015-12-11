.class public Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private addTimer:Z

.field private analyticsContext:Ljava/lang/String;

.field private colorTheme:Ljava/lang/String;

.field private offers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
            ">;"
        }
    .end annotation
.end field

.field private offersWide:I

.field private size:Ljava/lang/String;

.field private textAlignment:Ljava/lang/String;

.field private widgetType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAnalyticsContext()Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->analyticsContext:Ljava/lang/String;

    return-object v0
.end method

.method public getColorTheme()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->colorTheme:Ljava/lang/String;

    return-object v0
.end method

.method public getOffers()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->offers:Ljava/util/List;

    return-object v0
.end method

.method public getOffersWide()I
    .locals 1

    .prologue
    .line 69
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->offersWide:I

    return v0
.end method

.method public getSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->size:Ljava/lang/String;

    return-object v0
.end method

.method public getTextAlignment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->textAlignment:Ljava/lang/String;

    return-object v0
.end method

.method public getWidgetType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->widgetType:Ljava/lang/String;

    return-object v0
.end method

.method public isAddTimer()Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->addTimer:Z

    return v0
.end method

.method public setAddTimer(Z)V
    .locals 0

    .prologue
    .line 81
    iput-boolean p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->addTimer:Z

    .line 82
    return-void
.end method

.method public setAnalyticsContext(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->analyticsContext:Ljava/lang/String;

    .line 88
    return-void
.end method

.method public setColorTheme(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 93
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->colorTheme:Ljava/lang/String;

    .line 94
    return-void
.end method

.method public setOffers(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 123
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->offers:Ljava/util/List;

    .line 124
    return-void
.end method

.method public setOffersWide(I)V
    .locals 0

    .prologue
    .line 117
    iput p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->offersWide:I

    .line 118
    return-void
.end method

.method public setSize(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->size:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setTextAlignment(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->textAlignment:Ljava/lang/String;

    .line 106
    return-void
.end method

.method public setWidgetType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/Widget;->widgetType:Ljava/lang/String;

    .line 112
    return-void
.end method
