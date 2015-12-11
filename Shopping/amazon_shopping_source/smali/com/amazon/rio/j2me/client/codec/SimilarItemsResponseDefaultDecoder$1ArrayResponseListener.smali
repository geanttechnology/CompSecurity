.class final Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;
.super Ljava/lang/Object;
.source "SimilarItemsResponseDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/SimilarItemsResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "ArrayResponseListener"
.end annotation


# instance fields
.field private final path:[I

.field final synthetic this$0:Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;

.field final synthetic val$callback:Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;

.field final synthetic val$fieldPath:[I


# direct methods
.method constructor <init>(Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;[ILcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 25
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->this$0:Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder;

    iput-object p2, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->val$fieldPath:[I

    iput-object p3, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->val$callback:Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const/4 v0, 0x2

    new-array v0, v0, [I

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->val$fieldPath:[I

    aget v1, v1, v2

    aput v1, v0, v2

    const/4 v1, 0x1

    const/4 v2, -0x1

    aput v2, v0, v1

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->path:[I

    return-void
.end method


# virtual methods
.method public aboutToReceiveArrayOfSize(I[I)V
    .locals 2
    .param p1, "size"    # I
    .param p2, "path"    # [I

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->val$callback:Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->val$fieldPath:[I

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->aboutToReceiveArrayOfSize(I[I)V

    .line 32
    return-void
.end method

.method public receivedObject(Ljava/lang/Object;[I)V
    .locals 3
    .param p1, "data"    # Ljava/lang/Object;
    .param p2, "path"    # [I

    .prologue
    .line 35
    array-length v0, p2

    if-lez v0, :cond_0

    .line 37
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->path:[I

    const/4 v1, 0x1

    const/4 v2, 0x0

    aget v2, p2, v2

    aput v2, v0, v1

    .line 38
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->val$callback:Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/codec/SimilarItemsResponseDefaultDecoder$1ArrayResponseListener;->path:[I

    invoke-interface {v0, p1, v1}, Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;->receivedObject(Ljava/lang/Object;[I)V

    .line 40
    :cond_0
    return-void
.end method
