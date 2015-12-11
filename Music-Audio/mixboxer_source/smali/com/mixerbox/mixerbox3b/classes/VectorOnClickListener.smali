.class public Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field ctx:Landroid/content/Context;

.field j:Lorg/json/JSONObject;

.field jMain:Lorg/json/JSONObject;

.field jfkkk:Lorg/json/JSONObject;

.field type:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->ctx:Landroid/content/Context;

    .line 20
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->j:Lorg/json/JSONObject;

    .line 21
    iput-object p4, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->jfkkk:Lorg/json/JSONObject;

    .line 22
    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->jMain:Lorg/json/JSONObject;

    .line 25
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->j:Lorg/json/JSONObject;

    const-string v1, "type"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 26
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->j:Lorg/json/JSONObject;

    const-string v1, "type"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->type:Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 31
    :cond_0
    :goto_0
    return-void

    .line 27
    :catch_0
    move-exception v0

    .line 28
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 35
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->ctx:Landroid/content/Context;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->j:Lorg/json/JSONObject;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->jfkkk:Lorg/json/JSONObject;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;->jMain:Lorg/json/JSONObject;

    invoke-static {v0, v1, v2, v3, p1}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickHandle;->onClick(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;Landroid/view/View;)V

    .line 36
    return-void
.end method
