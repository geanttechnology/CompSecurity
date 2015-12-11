.class public interface abstract Lcom/google/android/gms/wearable/NodeApi;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/wearable/NodeApi$NodeListener;,
        Lcom/google/android/gms/wearable/NodeApi$GetConnectedNodesResult;
    }
.end annotation


# virtual methods
.method public abstract getConnectedNodes(Lcom/google/android/gms/common/api/GoogleApiClient;)Lcom/google/android/gms/common/api/PendingResult;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/GoogleApiClient;",
            ")",
            "Lcom/google/android/gms/common/api/PendingResult",
            "<",
            "Lcom/google/android/gms/wearable/NodeApi$GetConnectedNodesResult;",
            ">;"
        }
    .end annotation
.end method
