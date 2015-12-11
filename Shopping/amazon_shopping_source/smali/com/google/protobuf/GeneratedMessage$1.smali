.class final Lcom/google/protobuf/GeneratedMessage$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/protobuf/GeneratedMessage$ExtensionDescriptorRetriever;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/protobuf/GeneratedMessage;->newMessageScopedGeneratedExtension(Lcom/google/protobuf/Message;ILjava/lang/Class;Lcom/google/protobuf/Message;)Lcom/google/protobuf/GeneratedMessage$GeneratedExtension;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$descriptorIndex:I

.field final synthetic val$scope:Lcom/google/protobuf/Message;


# direct methods
.method constructor <init>(Lcom/google/protobuf/Message;I)V
    .locals 0

    iput-object p1, p0, Lcom/google/protobuf/GeneratedMessage$1;->val$scope:Lcom/google/protobuf/Message;

    iput p2, p0, Lcom/google/protobuf/GeneratedMessage$1;->val$descriptorIndex:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
