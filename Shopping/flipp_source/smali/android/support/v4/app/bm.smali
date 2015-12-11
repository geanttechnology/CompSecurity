.class public final Landroid/support/v4/app/bm;
.super Landroid/support/v4/app/ch;
.source "SourceFile"


# static fields
.field public static final d:Landroid/support/v4/app/ci;


# instance fields
.field public a:I

.field public b:Ljava/lang/CharSequence;

.field public c:Landroid/app/PendingIntent;

.field private final e:Landroid/os/Bundle;

.field private final f:[Landroid/support/v4/app/cq;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 2135
    new-instance v0, Landroid/support/v4/app/bn;

    invoke-direct {v0}, Landroid/support/v4/app/bn;-><init>()V

    sput-object v0, Landroid/support/v4/app/bm;->d:Landroid/support/v4/app/ci;

    return-void
.end method


# virtual methods
.method protected final a()I
    .locals 1

    .prologue
    .line 1805
    iget v0, p0, Landroid/support/v4/app/bm;->a:I

    return v0
.end method

.method protected final b()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 1810
    iget-object v0, p0, Landroid/support/v4/app/bm;->b:Ljava/lang/CharSequence;

    return-object v0
.end method

.method protected final c()Landroid/app/PendingIntent;
    .locals 1

    .prologue
    .line 1815
    iget-object v0, p0, Landroid/support/v4/app/bm;->c:Landroid/app/PendingIntent;

    return-object v0
.end method

.method public final d()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 1823
    iget-object v0, p0, Landroid/support/v4/app/bm;->e:Landroid/os/Bundle;

    return-object v0
.end method

.method public final bridge synthetic e()[Landroid/support/v4/app/cy;
    .locals 1

    .prologue
    .line 1772
    iget-object v0, p0, Landroid/support/v4/app/bm;->f:[Landroid/support/v4/app/cq;

    return-object v0
.end method
