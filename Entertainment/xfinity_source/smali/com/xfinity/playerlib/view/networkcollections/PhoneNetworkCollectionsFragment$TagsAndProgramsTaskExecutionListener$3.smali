.class Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$3;
.super Ljava/lang/Object;
.source "PhoneNetworkCollectionsFragment.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    .prologue
    .line 274
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$3;->this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public tryAgain()V
    .locals 1

    .prologue
    .line 277
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener$3;->this$1:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$TagsAndProgramsTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    # invokes: Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->fetchData()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->access$1300(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;)V

    .line 278
    return-void
.end method
