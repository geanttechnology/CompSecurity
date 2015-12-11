.class Lco/vine/android/widget/notifier/NotifyableRelativeLayout$1;
.super Ljava/lang/Object;
.source "NotifyableRelativeLayout.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->init(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/widget/notifier/NotifyableRelativeLayout;


# direct methods
.method constructor <init>(Lco/vine/android/widget/notifier/NotifyableRelativeLayout;)V
    .locals 0

    .prologue
    .line 68
    iput-object p1, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout$1;->this$0:Lco/vine/android/widget/notifier/NotifyableRelativeLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 71
    iget-object v0, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout$1;->this$0:Lco/vine/android/widget/notifier/NotifyableRelativeLayout;

    # getter for: Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mListener:Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;
    invoke-static {v0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->access$000(Lco/vine/android/widget/notifier/NotifyableRelativeLayout;)Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 72
    iget-object v0, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout$1;->this$0:Lco/vine/android/widget/notifier/NotifyableRelativeLayout;

    # getter for: Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mListener:Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;
    invoke-static {v0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->access$000(Lco/vine/android/widget/notifier/NotifyableRelativeLayout;)Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;

    move-result-object v0

    invoke-interface {v0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;->onNotifyClick()V

    .line 74
    :cond_0
    iget-object v0, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout$1;->this$0:Lco/vine/android/widget/notifier/NotifyableRelativeLayout;

    # invokes: Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->hideNotification()V
    invoke-static {v0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->access$100(Lco/vine/android/widget/notifier/NotifyableRelativeLayout;)V

    .line 75
    return-void
.end method
