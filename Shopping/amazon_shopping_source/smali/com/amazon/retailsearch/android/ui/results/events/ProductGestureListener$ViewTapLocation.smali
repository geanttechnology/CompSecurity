.class final enum Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;
.super Ljava/lang/Enum;
.source "ProductGestureListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "ViewTapLocation"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

.field public static final enum IN_VIEW:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

.field public static final enum MISS:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

.field public static final enum WITHIN_PADDING:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 213
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    const-string/jumbo v1, "MISS"

    invoke-direct {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->MISS:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    .line 214
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    const-string/jumbo v1, "IN_VIEW"

    invoke-direct {v0, v1, v3}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->IN_VIEW:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    .line 215
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    const-string/jumbo v1, "WITHIN_PADDING"

    invoke-direct {v0, v1, v4}, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->WITHIN_PADDING:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    .line 211
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->MISS:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->IN_VIEW:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->WITHIN_PADDING:Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->$VALUES:[Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 211
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 211
    const-class v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    return-object v0
.end method

.method public static values()[Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;
    .locals 1

    .prologue
    .line 211
    sget-object v0, Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->$VALUES:[Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    invoke-virtual {v0}, [Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/retailsearch/android/ui/results/events/ProductGestureListener$ViewTapLocation;

    return-object v0
.end method
