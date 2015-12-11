.class Lcom/wjj/utils/StickyLayout$1$1;
.super Ljava/lang/Object;
.source "StickyLayout.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wjj/utils/StickyLayout$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/wjj/utils/StickyLayout$1;

.field private final synthetic val$height:I


# direct methods
.method constructor <init>(Lcom/wjj/utils/StickyLayout$1;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/wjj/utils/StickyLayout$1$1;->this$1:Lcom/wjj/utils/StickyLayout$1;

    iput p2, p0, Lcom/wjj/utils/StickyLayout$1$1;->val$height:I

    .line 231
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 233
    iget-object v0, p0, Lcom/wjj/utils/StickyLayout$1$1;->this$1:Lcom/wjj/utils/StickyLayout$1;

    # getter for: Lcom/wjj/utils/StickyLayout$1;->this$0:Lcom/wjj/utils/StickyLayout;
    invoke-static {v0}, Lcom/wjj/utils/StickyLayout$1;->access$0(Lcom/wjj/utils/StickyLayout$1;)Lcom/wjj/utils/StickyLayout;

    move-result-object v0

    iget v1, p0, Lcom/wjj/utils/StickyLayout$1$1;->val$height:I

    invoke-virtual {v0, v1}, Lcom/wjj/utils/StickyLayout;->setHeaderHeight(I)V

    .line 234
    return-void
.end method
