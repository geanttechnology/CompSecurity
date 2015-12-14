.class Lcom/livemixtapes/SignUp$13;
.super Ljava/lang/Object;
.source "SignUp.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SignUp;->setListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SignUp;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SignUp;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SignUp$13;->this$0:Lcom/livemixtapes/SignUp;

    .line 442
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 447
    iget-object v0, p0, Lcom/livemixtapes/SignUp$13;->this$0:Lcom/livemixtapes/SignUp;

    invoke-virtual {v0}, Lcom/livemixtapes/SignUp;->onBackPressed()V

    .line 448
    return-void
.end method
