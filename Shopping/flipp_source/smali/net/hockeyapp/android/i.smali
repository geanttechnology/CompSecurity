.class final Lnet/hockeyapp/android/i;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lnet/hockeyapp/android/FeedbackActivity;


# direct methods
.method constructor <init>(Lnet/hockeyapp/android/FeedbackActivity;)V
    .locals 0

    .prologue
    .line 154
    iput-object p1, p0, Lnet/hockeyapp/android/i;->a:Lnet/hockeyapp/android/FeedbackActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 3

    .prologue
    .line 157
    sget-object v0, Lnet/hockeyapp/android/e/f;->a:Lnet/hockeyapp/android/e/e;

    iget-object v1, p0, Lnet/hockeyapp/android/i;->a:Lnet/hockeyapp/android/FeedbackActivity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lnet/hockeyapp/android/e/e;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 158
    iget-object v0, p0, Lnet/hockeyapp/android/i;->a:Lnet/hockeyapp/android/FeedbackActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnet/hockeyapp/android/FeedbackActivity;->a(Z)V

    .line 159
    return-void
.end method
