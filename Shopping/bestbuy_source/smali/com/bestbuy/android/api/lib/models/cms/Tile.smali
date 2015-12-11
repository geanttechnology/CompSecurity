.class public Lcom/bestbuy/android/api/lib/models/cms/Tile;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static TAG:Ljava/lang/String;


# instance fields
.field private conditionalVisibilityProperty:Ljava/lang/String;

.field private conditionalVisibilityPropertyValue:Ljava/lang/String;

.field private disabled:Z

.field private displayTitle:Ljava/lang/String;

.field private height:F

.field private image:Ljava/lang/String;

.field private index:I

.field private jsForEvaluationString:Ljava/lang/String;

.field private key:Ljava/lang/String;

.field private selectedImage:Ljava/lang/String;

.field private subTitle:Ljava/lang/String;

.field private targetURL:Ljava/lang/String;

.field private targetView:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private trackingTitle:Ljava/lang/String;

.field private width:F

.field private x:F


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/cms/Tile;
    .locals 4

    .prologue
    .line 137
    new-instance v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/cms/Tile;-><init>()V

    .line 138
    const-string v1, "title"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->title:Ljava/lang/String;

    .line 139
    const-string v1, "subTitle"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->subTitle:Ljava/lang/String;

    .line 140
    const-string v1, "image"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->image:Ljava/lang/String;

    .line 141
    const-string v1, "selectedImage"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->selectedImage:Ljava/lang/String;

    .line 142
    const-string v1, "x"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-float v1, v2

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->x:F

    .line 143
    const-string v1, "width"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-float v1, v2

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->width:F

    .line 144
    const-string v1, "height"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optDouble(Ljava/lang/String;)D

    move-result-wide v2

    double-to-float v1, v2

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->height:F

    .line 145
    const-string v1, "index"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optInt(Ljava/lang/String;)I

    move-result v1

    iput v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->index:I

    .line 146
    const-string v1, "targetURL"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->targetURL:Ljava/lang/String;

    .line 147
    const-string v1, "targetView"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->targetView:Ljava/lang/String;

    .line 148
    const-string v1, "trackingTitle"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->trackingTitle:Ljava/lang/String;

    .line 149
    const-string v1, "displayTitle"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->displayTitle:Ljava/lang/String;

    .line 150
    const-string v1, "jsForEvaluationString"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->jsForEvaluationString:Ljava/lang/String;

    .line 151
    const-string v1, "conditionalVisibilityProperty"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->conditionalVisibilityProperty:Ljava/lang/String;

    .line 152
    const-string v1, "conditionalVisibilityPropertyValue"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->conditionalVisibilityPropertyValue:Ljava/lang/String;

    .line 153
    const-string v1, "key"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->key:Ljava/lang/String;

    .line 154
    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->disabled:Z

    .line 155
    return-object v0
.end method


# virtual methods
.method public getConditionalVisibilityProperty()Ljava/lang/String;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->conditionalVisibilityProperty:Ljava/lang/String;

    return-object v0
.end method

.method public getConditionalVisibilityPropertyValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->conditionalVisibilityPropertyValue:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->displayTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getHeight()F
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->height:F

    return v0
.end method

.method public getImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->image:Ljava/lang/String;

    return-object v0
.end method

.method public getIndex()I
    .locals 1

    .prologue
    .line 79
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->index:I

    return v0
.end method

.method public getJsForEvaluationString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->jsForEvaluationString:Ljava/lang/String;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->key:Ljava/lang/String;

    return-object v0
.end method

.method public getSelectedImage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->selectedImage:Ljava/lang/String;

    return-object v0
.end method

.method public getSubTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->subTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getTargetURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->targetURL:Ljava/lang/String;

    return-object v0
.end method

.method public getTargetView()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->targetView:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getTrackingTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->trackingTitle:Ljava/lang/String;

    return-object v0
.end method

.method public getWidth()F
    .locals 1

    .prologue
    .line 67
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->width:F

    return v0
.end method

.method public getX()F
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->x:F

    return v0
.end method

.method public isDisabled()Z
    .locals 1

    .prologue
    .line 133
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/cms/Tile;->disabled:Z

    return v0
.end method
