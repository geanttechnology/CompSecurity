.class public Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;
.super Ljava/lang/Object;
.source "NewAccountRequest.java"


# instance fields
.field private captchaId:Ljava/lang/String;

.field private captchaResponse:Ljava/lang/String;

.field private dob:Lcom/amazon/rio/j2me/client/services/mShop/Date;

.field private email:Ljava/lang/String;

.field private forceMase:Ljava/lang/Boolean;

.field private fullName:Ljava/lang/String;

.field private password:Ljava/lang/String;

.field private pronunciation:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCaptchaId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->captchaId:Ljava/lang/String;

    return-object v0
.end method

.method public getCaptchaResponse()Ljava/lang/String;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->captchaResponse:Ljava/lang/String;

    return-object v0
.end method

.method public getDob()Lcom/amazon/rio/j2me/client/services/mShop/Date;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->dob:Lcom/amazon/rio/j2me/client/services/mShop/Date;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->email:Ljava/lang/String;

    return-object v0
.end method

.method public getForceMase()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->forceMase:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getFullName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->fullName:Ljava/lang/String;

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getPronunciation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->pronunciation:Ljava/lang/String;

    return-object v0
.end method

.method public setEmail(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->email:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setForceMase(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 101
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->forceMase:Ljava/lang/Boolean;

    .line 102
    return-void
.end method

.method public setFullName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->fullName:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public setPassword(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->password:Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setPronunciation(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NewAccountRequest;->pronunciation:Ljava/lang/String;

    .line 63
    return-void
.end method
