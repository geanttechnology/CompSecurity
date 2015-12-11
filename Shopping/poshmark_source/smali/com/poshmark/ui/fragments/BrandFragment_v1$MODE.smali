.class public final enum Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;
.super Ljava/lang/Enum;
.source "BrandFragment_v1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/BrandFragment_v1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MODE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

.field public static final enum ALL:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

.field public static final enum JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 70
    new-instance v0, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    const-string v1, "JUST_IN"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    new-instance v0, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    const-string v1, "ALL"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->ALL:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    sget-object v1, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->JUST_IN:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->ALL:Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    aput-object v1, v0, v3

    sput-object v0, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

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
    .line 70
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 70
    const-class v0, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;
    .locals 1

    .prologue
    .line 70
    sget-object v0, Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->$VALUES:[Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    invoke-virtual {v0}, [Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/ui/fragments/BrandFragment_v1$MODE;

    return-object v0
.end method
