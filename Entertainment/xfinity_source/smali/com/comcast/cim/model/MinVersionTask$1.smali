.class Lcom/comcast/cim/model/MinVersionTask$1;
.super Ljava/lang/Object;
.source "MinVersionTask.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/model/MinVersionTask;->fetchResourceWithNoCache()Ljava/lang/Integer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<",
        "Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/model/MinVersionTask;


# direct methods
.method constructor <init>(Lcom/comcast/cim/model/MinVersionTask;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/model/MinVersionTask;

    .prologue
    .line 33
    .local p0, "this":Lcom/comcast/cim/model/MinVersionTask$1;, "Lcom/comcast/cim/model/MinVersionTask$1;"
    iput-object p1, p0, Lcom/comcast/cim/model/MinVersionTask$1;->this$0:Lcom/comcast/cim/model/MinVersionTask;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;
    .locals 1

    .prologue
    .line 35
    .local p0, "this":Lcom/comcast/cim/model/MinVersionTask$1;, "Lcom/comcast/cim/model/MinVersionTask$1;"
    new-instance v0, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;

    invoke-direct {v0}, Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;-><init>()V

    return-object v0
.end method

.method public bridge synthetic get()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 33
    .local p0, "this":Lcom/comcast/cim/model/MinVersionTask$1;, "Lcom/comcast/cim/model/MinVersionTask$1;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/MinVersionTask$1;->get()Lcom/comcast/cim/android/version/MinVersionCheckResponseHandler;

    move-result-object v0

    return-object v0
.end method
