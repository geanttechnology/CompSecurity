.class final Lcom/wishabi/flipp/app/es;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/preference/Preference$OnPreferenceChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/eq;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/eq;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/wishabi/flipp/app/es;->a:Lcom/wishabi/flipp/app/eq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 3

    .prologue
    .line 77
    check-cast p2, Ljava/lang/Boolean;

    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 78
    iget-object v1, p0, Lcom/wishabi/flipp/app/es;->a:Lcom/wishabi/flipp/app/eq;

    const-string v2, "clear_search_history"

    invoke-virtual {v1, v2}, Lcom/wishabi/flipp/app/eq;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v1

    .line 79
    invoke-virtual {v1, v0}, Landroid/preference/Preference;->setEnabled(Z)V

    .line 86
    const/4 v0, 0x1

    return v0
.end method
