.class final Lcom/wishabi/flipp/app/ay;
.super Lnet/hockeyapp/android/g;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/FlippApplication;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/FlippApplication;)V
    .locals 0

    .prologue
    .line 151
    iput-object p1, p0, Lcom/wishabi/flipp/app/ay;->a:Lcom/wishabi/flipp/app/FlippApplication;

    invoke-direct {p0}, Lnet/hockeyapp/android/g;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()Z
    .locals 1

    .prologue
    .line 153
    const/4 v0, 0x1

    return v0
.end method

.method public final b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    invoke-virtual {v0}, Lcom/wishabi/flipp/b/a;->d()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
