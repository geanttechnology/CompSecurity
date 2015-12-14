.class Lcom/livemixtapes/Mixtapes$15;
.super Ljava/lang/Object;
.source "Mixtapes.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtapes;->addDots(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtapes;

.field private final synthetic val$count:I


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtapes;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$15;->this$0:Lcom/livemixtapes/Mixtapes;

    iput p2, p0, Lcom/livemixtapes/Mixtapes$15;->val$count:I

    .line 827
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 0
    .param p1, "state"    # I

    .prologue
    .line 840
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    .line 831
    return-void
.end method

.method public onPageSelected(I)V
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 835
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$15;->this$0:Lcom/livemixtapes/Mixtapes;

    iget v1, p0, Lcom/livemixtapes/Mixtapes$15;->val$count:I

    invoke-virtual {v0, v1, p1}, Lcom/livemixtapes/Mixtapes;->selectDot(II)V

    .line 836
    return-void
.end method
