.class Lcom/facebook/contacts/ai;
.super Lcom/facebook/inject/d;
.source "ContactsLibModule.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/facebook/inject/d",
        "<",
        "Lcom/facebook/contacts/g/i;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:Lcom/facebook/contacts/a;


# direct methods
.method private constructor <init>(Lcom/facebook/contacts/a;)V
    .locals 0

    .prologue
    .line 369
    iput-object p1, p0, Lcom/facebook/contacts/ai;->a:Lcom/facebook/contacts/a;

    invoke-direct {p0}, Lcom/facebook/inject/d;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/facebook/contacts/a;Lcom/facebook/contacts/b;)V
    .locals 0

    .prologue
    .line 369
    invoke-direct {p0, p1}, Lcom/facebook/contacts/ai;-><init>(Lcom/facebook/contacts/a;)V

    return-void
.end method


# virtual methods
.method public a()Lcom/facebook/contacts/g/i;
    .locals 4

    .prologue
    .line 373
    new-instance v2, Lcom/facebook/contacts/g/i;

    const-class v0, Lcom/facebook/contacts/c/a;

    invoke-virtual {p0, v0}, Lcom/facebook/contacts/ai;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/facebook/contacts/c/a;

    const-class v1, Lcom/facebook/contacts/c/b;

    const-class v3, Lcom/facebook/contacts/annotations/ForContactSummary;

    invoke-virtual {p0, v1, v3}, Lcom/facebook/contacts/ai;->a(Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/facebook/contacts/c/b;

    invoke-direct {v2, v0, v1}, Lcom/facebook/contacts/g/i;-><init>(Lcom/facebook/contacts/c/a;Lcom/facebook/contacts/c/b;)V

    return-object v2
.end method

.method public synthetic b()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 369
    invoke-virtual {p0}, Lcom/facebook/contacts/ai;->a()Lcom/facebook/contacts/g/i;

    move-result-object v0

    return-object v0
.end method
