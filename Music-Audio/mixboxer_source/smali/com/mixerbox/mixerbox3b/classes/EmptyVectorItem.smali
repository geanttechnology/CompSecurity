.class public Lcom/mixerbox/mixerbox3b/classes/EmptyVectorItem;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/mixerbox/mixerbox3b/classes/MyItem;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    return-void
.end method


# virtual methods
.method public getMyJSONObject()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 27
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    return-object v0
.end method

.method public getView(Landroid/view/LayoutInflater;Landroid/view/View;)Landroid/view/View;
    .locals 2

    .prologue
    .line 20
    if-nez p2, :cond_0

    .line 21
    const v0, 0x7f030049

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 23
    :cond_0
    return-object p2
.end method

.method public getViewType()I
    .locals 1

    .prologue
    .line 16
    sget-object v0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->EMPTY_ITEM:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->ordinal()I

    move-result v0

    return v0
.end method
