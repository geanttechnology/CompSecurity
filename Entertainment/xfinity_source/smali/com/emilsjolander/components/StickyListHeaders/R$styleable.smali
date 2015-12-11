.class public final Lcom/emilsjolander/components/StickyListHeaders/R$styleable;
.super Ljava/lang/Object;
.source "R.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/emilsjolander/components/StickyListHeaders/R;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "styleable"
.end annotation


# static fields
.field public static final StickyListHeadersListView:[I

.field public static final StickyListHeadersListView_areHeadersSticky:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 29
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x7f01001a

    aput v2, v0, v1

    sput-object v0, Lcom/emilsjolander/components/StickyListHeaders/R$styleable;->StickyListHeadersListView:[I

    return-void
.end method
