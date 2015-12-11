.class final Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;
.super Ljava/lang/Object;
.source "BatchCredentialsParser.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "ReferenceInfo"
.end annotation


# instance fields
.field private final mCredType:Ljava/lang/String;

.field private final mDeviceType:Ljava/lang/String;

.field private final mRefDeviceType:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceType"    # Ljava/lang/String;
    .param p2, "credType"    # Ljava/lang/String;
    .param p3, "refDeviceType"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->mDeviceType:Ljava/lang/String;

    .line 39
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->mCredType:Ljava/lang/String;

    .line 40
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->mRefDeviceType:Ljava/lang/String;

    .line 41
    return-void
.end method


# virtual methods
.method public getCredentialType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->mCredType:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->mDeviceType:Ljava/lang/String;

    return-object v0
.end method

.method public getReferenceDeviceType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser$ReferenceInfo;->mRefDeviceType:Ljava/lang/String;

    return-object v0
.end method
