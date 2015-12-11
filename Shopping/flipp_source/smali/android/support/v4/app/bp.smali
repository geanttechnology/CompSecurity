.class public final Landroid/support/v4/app/bp;
.super Landroid/support/v4/app/cb;
.source "SourceFile"


# instance fields
.field a:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1667
    invoke-direct {p0}, Landroid/support/v4/app/cb;-><init>()V

    .line 1668
    return-void
.end method


# virtual methods
.method public final a(Ljava/lang/CharSequence;)Landroid/support/v4/app/bp;
    .locals 1

    .prologue
    .line 1697
    invoke-static {p1}, Landroid/support/v4/app/bq;->c(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/bp;->a:Ljava/lang/CharSequence;

    .line 1698
    return-object p0
.end method
