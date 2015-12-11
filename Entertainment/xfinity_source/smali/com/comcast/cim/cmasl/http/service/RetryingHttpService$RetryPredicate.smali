.class public interface abstract Lcom/comcast/cim/cmasl/http/service/RetryingHttpService$RetryPredicate;
.super Ljava/lang/Object;
.source "RetryingHttpService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/http/service/RetryingHttpService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "RetryPredicate"
.end annotation


# virtual methods
.method public abstract shouldRetry(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;I)Z
.end method
