.class final Lnet/hockeyapp/android/d/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lnet/hockeyapp/android/d/d;


# direct methods
.method constructor <init>(Lnet/hockeyapp/android/d/d;)V
    .locals 0

    .prologue
    .line 203
    iput-object p1, p0, Lnet/hockeyapp/android/d/f;->a:Lnet/hockeyapp/android/d/d;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 205
    iget-object v0, p0, Lnet/hockeyapp/android/d/f;->a:Lnet/hockeyapp/android/d/d;

    invoke-static {v0}, Lnet/hockeyapp/android/d/d;->a(Lnet/hockeyapp/android/d/d;)Lnet/hockeyapp/android/b/a;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnet/hockeyapp/android/b/a;->a(Ljava/lang/Boolean;)V

    .line 206
    return-void
.end method
