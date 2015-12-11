.class public final enum Lcom/poshmark/ui/fragments/BrandFragment$MODE;
.super Ljava/lang/Enum;
.source "BrandFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/BrandFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/BrandFragment$MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/BrandFragment$MODE;

.field public static final enum ALL:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

.field public static final enum JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

.field public static final enum PRICE_DROP:Lcom/poshmark/ui/fragments/BrandFragment$MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 75
    new-instance v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    const-string v1, "JUST_IN"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/BrandFragment$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    new-instance v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    const-string v1, "ALL"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/BrandFragment$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    new-instance v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    const-string v1, "PRICE_DROP"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/ui/fragments/BrandFragment$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->ALL:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->PRICE_DROP:Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    aput-object v1, v0, v4

    sput-object v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/BrandFragment$MODE;

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
    .line 75
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/BrandFragment$MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 75
    const-class v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/BrandFragment$MODE;
    .locals 1

    .prologue
    .line 75
    sget-object v0, Lcom/poshmark/ui/fragments/BrandFragment$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/BrandFragment$MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/BrandFragment$MODE;

    return-object v0
.end method
