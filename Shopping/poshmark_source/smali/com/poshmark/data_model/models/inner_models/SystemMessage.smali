.class public Lcom/poshmark/data_model/models/inner_models/SystemMessage;
.super Ljava/lang/Object;
.source "SystemMessage.java"


# instance fields
.field destination_url:Ljava/lang/String;

.field image_url:Ljava/lang/String;

.field message:Ljava/lang/String;

.field name:Ljava/lang/String;

.field right_image_url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDestinationUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->destination_url:Ljava/lang/String;

    return-object v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->image_url:Ljava/lang/String;

    return-object v0
.end method

.method public getMessageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getMessageText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->message:Ljava/lang/String;

    return-object v0
.end method

.method public getRightImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->right_image_url:Ljava/lang/String;

    return-object v0
.end method

.method public setDestinationUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "destination_url"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->destination_url:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "image_url"    # Ljava/lang/String;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->image_url:Ljava/lang/String;

    .line 46
    return-void
.end method

.method public setMessageName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 21
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->name:Ljava/lang/String;

    .line 22
    return-void
.end method

.method public setMessageText(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/poshmark/data_model/models/inner_models/SystemMessage;->message:Ljava/lang/String;

    .line 30
    return-void
.end method
