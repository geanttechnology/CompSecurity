.class Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;
.super Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem;

.field final synthetic val$tvFollow:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem;Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Landroid/widget/TextView;)V
    .locals 0

    .prologue
    .line 145
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->this$0:Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem;

    iput-object p6, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->val$tvFollow:Landroid/widget/TextView;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    const/16 v3, 0x10

    .line 149
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->val$tvFollow:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08014c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 150
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v3, :cond_1

    .line 151
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->val$tvFollow:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f02011f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 154
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->val$tvFollow:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f06001d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 165
    :cond_0
    :goto_1
    invoke-super {p0, p1}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->onClick(Landroid/view/View;)V

    .line 166
    return-void

    .line 153
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->val$tvFollow:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f02011f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_1

    .line 156
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->val$tvFollow:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08014d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 157
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v3, :cond_3

    .line 158
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->val$tvFollow:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f020120

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 161
    :goto_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->val$tvFollow:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060018

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 160
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->val$tvFollow:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/DJInfoVectorItem$1;->ctx:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f020120

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method
