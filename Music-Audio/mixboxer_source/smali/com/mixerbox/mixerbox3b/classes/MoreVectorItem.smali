.class public Lcom/mixerbox/mixerbox3b/classes/MoreVectorItem;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/mixerbox/mixerbox3b/classes/MyItem;


# instance fields
.field private ctx:Landroid/content/Context;

.field private jOb:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/MoreVectorItem;->jOb:Lorg/json/JSONObject;

    .line 18
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MoreVectorItem;->ctx:Landroid/content/Context;

    .line 19
    return-void
.end method


# virtual methods
.method public getMyJSONObject()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MoreVectorItem;->jOb:Lorg/json/JSONObject;

    return-object v0
.end method

.method public getView(Landroid/view/LayoutInflater;Landroid/view/View;)Landroid/view/View;
    .locals 4

    .prologue
    .line 26
    if-nez p2, :cond_0

    .line 27
    const v0, 0x7f03004b

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 29
    :cond_0
    const v0, 0x7f070118

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 30
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MoreVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800fb

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " >"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 31
    return-object p2
.end method

.method public getViewType()I
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->MORE_ITEM:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->ordinal()I

    move-result v0

    return v0
.end method
