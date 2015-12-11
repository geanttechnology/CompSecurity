.class public final enum Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;
.super Ljava/lang/Enum;
.source "MyLikesFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/MyLikesFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

.field public static final enum ALL:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

.field public static final enum BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

.field public static final enum PRICE_DROP:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 64
    new-instance v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    const-string v1, "BUNDLES"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    new-instance v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    const-string v1, "ALL"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    new-instance v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    const-string v1, "PRICE_DROP"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->BUNDLES:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    aput-object v1, v0, v4

    sput-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

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
    .line 64
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 64
    const-class v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;
    .locals 1

    .prologue
    .line 64
    sget-object v0, Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/MyLikesFragment$MODE;

    return-object v0
.end method
