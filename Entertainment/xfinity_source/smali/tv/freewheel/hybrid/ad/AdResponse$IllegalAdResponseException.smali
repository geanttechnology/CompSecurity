.class public final Ltv/freewheel/hybrid/ad/AdResponse$IllegalAdResponseException;
.super Ljava/lang/Exception;
.source "AdResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/ad/AdResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "IllegalAdResponseException"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 40
    return-void
.end method
