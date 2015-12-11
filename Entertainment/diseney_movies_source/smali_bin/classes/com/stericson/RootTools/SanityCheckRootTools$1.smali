.class Lcom/stericson/RootTools/SanityCheckRootTools$1;
.super Ljava/lang/Object;
.source "SanityCheckRootTools.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/stericson/RootTools/SanityCheckRootTools;->print(Ljava/lang/CharSequence;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/stericson/RootTools/SanityCheckRootTools;


# direct methods
.method constructor <init>(Lcom/stericson/RootTools/SanityCheckRootTools;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/stericson/RootTools/SanityCheckRootTools$1;->this$0:Lcom/stericson/RootTools/SanityCheckRootTools;

    .line 85
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 87
    iget-object v0, p0, Lcom/stericson/RootTools/SanityCheckRootTools$1;->this$0:Lcom/stericson/RootTools/SanityCheckRootTools;

    # getter for: Lcom/stericson/RootTools/SanityCheckRootTools;->mScrollView:Landroid/widget/ScrollView;
    invoke-static {v0}, Lcom/stericson/RootTools/SanityCheckRootTools;->access$1(Lcom/stericson/RootTools/SanityCheckRootTools;)Landroid/widget/ScrollView;

    move-result-object v0

    const/16 v1, 0x82

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->fullScroll(I)Z

    .line 88
    return-void
.end method
