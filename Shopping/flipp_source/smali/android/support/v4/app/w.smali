.class public final Landroid/support/v4/app/w;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public a:Landroid/support/v4/c/a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/c/a",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field public c:Landroid/support/v4/app/ax;

.field public d:Landroid/view/View;

.field final synthetic e:Landroid/support/v4/app/r;


# direct methods
.method public constructor <init>(Landroid/support/v4/app/r;)V
    .locals 1

    .prologue
    .line 1452
    iput-object p1, p0, Landroid/support/v4/app/w;->e:Landroid/support/v4/app/r;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1453
    new-instance v0, Landroid/support/v4/c/a;

    invoke-direct {v0}, Landroid/support/v4/c/a;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/w;->a:Landroid/support/v4/c/a;

    .line 1454
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/w;->b:Ljava/util/ArrayList;

    .line 1456
    new-instance v0, Landroid/support/v4/app/ax;

    invoke-direct {v0}, Landroid/support/v4/app/ax;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/w;->c:Landroid/support/v4/app/ax;

    return-void
.end method
