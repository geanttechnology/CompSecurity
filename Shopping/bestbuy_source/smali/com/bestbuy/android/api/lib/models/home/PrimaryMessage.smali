.class public Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x695aeaeca2ff8786L


# instance fields
.field private analyticsContext:Ljava/lang/String;

.field private colorTheme:Ljava/lang/String;

.field private content:Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;

.field private displayDisclaimer:Ljava/lang/String;

.field private placement:Ljava/lang/String;

.field private primaryMessageStyle:Ljava/lang/String;

.field private primaryMessageType:Ljava/lang/String;

.field private smallPlacement:Ljava/lang/String;

.field private widgetType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAnalyticsContext()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->analyticsContext:Ljava/lang/String;

    return-object v0
.end method

.method public getColorTheme()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->colorTheme:Ljava/lang/String;

    return-object v0
.end method

.method public getContent()Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->content:Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;

    return-object v0
.end method

.method public getDisplayDisclaimer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->displayDisclaimer:Ljava/lang/String;

    return-object v0
.end method

.method public getPlacement()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->placement:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimaryMessageStyle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->primaryMessageStyle:Ljava/lang/String;

    return-object v0
.end method

.method public getPrimaryMessageType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->primaryMessageType:Ljava/lang/String;

    return-object v0
.end method

.method public getSmallPlacement()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->smallPlacement:Ljava/lang/String;

    return-object v0
.end method

.method public getWidgetType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->widgetType:Ljava/lang/String;

    return-object v0
.end method

.method public setAnalyticsContext(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->analyticsContext:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setColorTheme(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->colorTheme:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setContent(Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->content:Lcom/bestbuy/android/api/lib/models/home/PrimaryMessageContent;

    .line 136
    return-void
.end method

.method public setDisplayDisclaimer(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->displayDisclaimer:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setPlacement(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->placement:Ljava/lang/String;

    .line 75
    return-void
.end method

.method public setPrimaryMessageStyle(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->primaryMessageStyle:Ljava/lang/String;

    .line 99
    return-void
.end method

.method public setPrimaryMessageType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 110
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->primaryMessageType:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public setSmallPlacement(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->smallPlacement:Ljava/lang/String;

    .line 87
    return-void
.end method

.method public setWidgetType(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 122
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/home/PrimaryMessage;->widgetType:Ljava/lang/String;

    .line 123
    return-void
.end method
