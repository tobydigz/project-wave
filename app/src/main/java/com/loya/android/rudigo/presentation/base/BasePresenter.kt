package xyz.anc4g.places.presentation.base

/**
 * Base presenter.
 *
 * @param <V> - View
 */
interface BasePresenter<V> {

    fun onAttach(view: V)

    fun onDetach()

}
