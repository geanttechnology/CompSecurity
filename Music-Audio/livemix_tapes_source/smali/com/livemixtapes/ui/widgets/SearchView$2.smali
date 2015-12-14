.class Lcom/livemixtapes/ui/widgets/SearchView$2;
.super Ljava/lang/Object;
.source "SearchView.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/ui/widgets/SearchView;->synthesize()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/ui/widgets/SearchView;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ui/widgets/SearchView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView$2;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    .line 116
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 2

    .prologue
    .line 121
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$2;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$2;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->layoutHint:Landroid/widget/LinearLayout;
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$1(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/LinearLayout;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getWidth()I

    move-result v1

    iput v1, v0, Lcom/livemixtapes/ui/widgets/SearchView;->widthHint:I

    .line 122
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$2;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->layoutHint:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$1(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 123
    return-void
.end method
