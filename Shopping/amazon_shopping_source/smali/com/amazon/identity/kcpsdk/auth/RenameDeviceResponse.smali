.class public Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;
.super Ljava/lang/Object;
.source "RenameDeviceResponse.java"


# instance fields
.field private final mError:I

.field private final mMessage:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "error"    # I

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;->mMessage:Ljava/lang/String;

    .line 12
    iput p2, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;->mError:I

    .line 13
    return-void
.end method


# virtual methods
.method public getError()I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;->mError:I

    return v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RenameDeviceResponse;->mMessage:Ljava/lang/String;

    return-object v0
.end method
