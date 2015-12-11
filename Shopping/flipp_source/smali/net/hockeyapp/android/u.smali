.class final Lnet/hockeyapp/android/u;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lnet/hockeyapp/android/UpdateActivity;


# direct methods
.method constructor <init>(Lnet/hockeyapp/android/UpdateActivity;)V
    .locals 0

    .prologue
    .line 327
    iput-object p1, p0, Lnet/hockeyapp/android/u;->a:Lnet/hockeyapp/android/UpdateActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 329
    iget-object v0, p0, Lnet/hockeyapp/android/u;->a:Lnet/hockeyapp/android/UpdateActivity;

    invoke-static {v0}, Lnet/hockeyapp/android/UpdateActivity;->a(Lnet/hockeyapp/android/UpdateActivity;)Lnet/hockeyapp/android/c/a;

    .line 330
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 331
    return-void
.end method
