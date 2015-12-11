.class public Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;
.super Ljava/lang/Object;
.source "FSECameraActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/FSECameraActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "FSECredentials"
.end annotation


# instance fields
.field private mApplicationKey:Ljava/lang/String;

.field private mSecret:Ljava/lang/String;

.field private mUser:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/FSECameraActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/FSECameraActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p2, "a_user"    # Ljava/lang/String;
    .param p3, "a_secret"    # Ljava/lang/String;
    .param p4, "a_applicationKey"    # Ljava/lang/String;

    .prologue
    .line 559
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->this$0:Lcom/amazon/mShop/search/viewit/FSECameraActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 560
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->mUser:Ljava/lang/String;

    .line 561
    iput-object p3, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->mSecret:Ljava/lang/String;

    .line 562
    iput-object p4, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->mApplicationKey:Ljava/lang/String;

    .line 563
    return-void
.end method


# virtual methods
.method public getApplicationKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 582
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->mApplicationKey:Ljava/lang/String;

    return-object v0
.end method

.method public getSecret()Ljava/lang/String;
    .locals 1

    .prologue
    .line 574
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->mSecret:Ljava/lang/String;

    return-object v0
.end method

.method public getUser()Ljava/lang/String;
    .locals 1

    .prologue
    .line 566
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FSECameraActivity$FSECredentials;->mUser:Ljava/lang/String;

    return-object v0
.end method
