.class final Lnet/hockeyapp/android/k;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lnet/hockeyapp/android/j;


# direct methods
.method constructor <init>(Lnet/hockeyapp/android/j;)V
    .locals 0

    .prologue
    .line 200
    iput-object p1, p0, Lnet/hockeyapp/android/k;->a:Lnet/hockeyapp/android/j;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 205
    iget-object v0, p0, Lnet/hockeyapp/android/k;->a:Lnet/hockeyapp/android/j;

    iget-object v0, v0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnet/hockeyapp/android/FeedbackActivity;->b(Z)V

    .line 206
    iget-object v0, p0, Lnet/hockeyapp/android/k;->a:Lnet/hockeyapp/android/j;

    iget-object v0, v0, Lnet/hockeyapp/android/j;->a:Lnet/hockeyapp/android/FeedbackActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnet/hockeyapp/android/FeedbackActivity;->showDialog(I)V

    .line 207
    return-void
.end method
